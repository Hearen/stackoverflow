#!/bin/bash

##
# @Author: LHearen@gmail.com or luo_so@worksap.co.jp
# @Date: Wed Oct 24 16:53:28 HKT 2018
# @Description: This script is used to auto-generate the deployment scripts for OPT IR environment.
# @Wiki: https://scm.hue.workslan/operation-tool/resource-controller/issues/8
##

# the name of this script
THIS_SCRIPT_NAME=$(basename "$0")

# to get absolute path for each file and folder
BASE_DIR=$(pwd)

# ansible-multi absolute path
ANSIBLE_MULTI_DIR="$HOME/ansible-multi";

# will be set via a function later
LATEST_VALID_VERSION="";

# the final source folder name to generate
SOURCE_FOLDER_NAME="operation-tool-deploy-script";

# the source folder is in the same directory by default
DEFAULT_SOURCE_DIR="${BASE_DIR}/${SOURCE_FOLDER_NAME}";

# for consistency and simplicity we only use absolute path
VARS_DIR="${DEFAULT_SOURCE_DIR}/opt-deploy/vars";
EXECUTABLE_DIR="${DEFAULT_SOURCE_DIR}/opt-deploy"

# for specific file, we use _PATH instead of _DIR as suffix
THE_MAIN_PATH="${DEFAULT_SOURCE_DIR}/opt-deploy/vars/main.yml";

# default keys directory
DEFAULT_PEM_DIR="~/keys"

# default new version will be the latest version
# a backup is required compulsively
DEFAULT_NEW_VERSION=""


##### UTIL CONFIGURATION AREA

# supported compressed file type and related commands
# command available checking required compulsively
SUPPORTED_COMPRESSED_TYPES=('tar' 'zip' 'tar.gz' 'tar.bz2')
UNCOMPRESS_COMMANDS=('tar -xf' 'unzip -oq' 'tar -xzf' 'tar -xjf')

# colors available
readonly GREEN_SETTER=`tput setaf 2`;
readonly RED_SETTER=`tput setaf 1`;
readonly BOLD_SETTER=`tput bold`;
readonly DIM_SETTER=`tput dim`
readonly COLOR_RESET=`tput sgr0`;


function exitWithMsg() {
    exitCode=$1
    msg=$2
    [[ ${exitCode} -eq 0 ]] && return 0;
    [[ ! -z "${msg}"  ]] && echo "${RED_SETTER}${msg}${COLOR_RESET}" 1>&2
    showHelp;
    exit ${exitCode}
}


function showHelp() {
    echo -e "\n${RED_SETTER}*** Sorry for this inconvenience ***\n";
    echo -e "${GREEN_SETTER}Follow the following commands to collect the debug info.\n"
    echo "export PS4='(${BASH_SOURCE}:${LINENO}): - [${SHLVL},${BASH_SUBSHELL},$?] $ '"
    echo "bash -x ${THIS_SCRIPT_NAME}";
    echo -e "\n\n****************************************************************************\n\n"
    echo -e "Contact ${BOLD_SETTER}Hearen@morphling-developer${DIM_SETTER} for further help, remember to enclose the debug info please.\n"
    echo -e ":( Sorry :(${COLOR_RESET}\n\n\n\n\n";
}

function updateDefaultValue() {
    local defaultValueName=$1
    echo "Press <Enter> to use default ${!defaultValueName} or input new below: "
    read newValue
    [[ -z ${newValue} ]] || eval ${defaultValueName}=${newValue}
}


function setLatestValidVersion() {
    echo "Getting the latest valid version under ${ANSIBLE_MULTI_DIR}";
    LATEST_VALID_VERSION=$(ls ${ANSIBLE_MULTI_DIR} | grep -Eo '[0-9]{2}\.[0-9]{2}\.[0-9]{2}\.[0-9]{4}$' | tail -n 1);
    exitWithMsg $? "No latest valid version found in ${ANSIBLE_MULTI_DIR}";
}

function copyTheMainYml() {
    version=$1
    echo "Start to copy main.yml from old to new..."
    cp ${ANSIBLE_MULTI_DIR}/${version}/vars/main.yml ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/vars/main.yml
    exitWithMsg $? "${RED_SETTER}Copy main.yml failed${COLOR_RESET}"
    echo "${GREEN_SETTER}Copy main.yml${BOLD_SETTER} SUCCESSFULLY${COLOR_RESET}"
}

function getValueByKeyInConst() {
    local theKey=$1
    local thePair=$(cat ${THE_MAIN_PATH} | grep -Eo "^${theKey}: .+";
    exitWithMsg $? "Key ${theKey} not found in ${THE_MAIN_PATH}";
    echo ${thePair} | sed -e "s/${theKey}://g");
}

function copyPemFiles() {
    echo "Start to copy pem files..."
    cp ${DEFAULT_PEM_DIR}/ ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/vars/
    exitWithMsg $? "${RED_SETTER}Copy pem files failed${COLOR_RESET}"
    echo "${GREEN_SETTER}Copy pem files${BOLD_SETTER} SUCCESSFULLY${COLOR_RESET}"
}

function configureAnsibleCfg() {
    echo "Start to create ansible.cfg..."
    echo "[defaults]" > ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/ansible.cfg
    echo "host_key_checking = False" >> ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/ansible.cfg
    echo "library = ${BASE_DIR}/operation-tool-deploy-script/library" >> ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/ansible.cfg
    exitWithMsg 1 "Creating ansible.cfg failed!"
    echo "${GREEN_SETTER}ansible.cfg created${BOLD_SETTER} SUCCESSFULLY${COLOR_RESET}"
}

function updateVersionInConst() {
    echo "Start to update VERSION in vars/const.yml";
    local version=$1;
    sed -i "s/^VERSION:$/VERSION:\"${version}\"/" ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/vars/const.yml;
    exitWithMsg 1 "Updating VERSION in vars/const.yml failed!"
    echo "${GREEN_SETTER}VERSION in vars/const.yml updated ${BOLD_SETTER} SUCCESSFULLY${COLOR_RESET}";
}

function finalValidate() {
    echo "Almost finished, having a final check...";
    ${BASE_DIR}/operation-tool-deploy-script/opt-deploy/verify-pre-conditions.sh 1>/dev/null
    exitWithMsg 1 "Please check the details above."
    echo "${GREEN_SETTER}Everything configured properly, ${BOLD_SETTER}WE'RE GOOD TO GO!${COLOR_RESET}";
}

# check the repo or compressed file is latest 
# within latest 2 hours
function checkLatest() {
    local fileToCheck=$1
    if test `find "${fileToCheck}" -mmin +120`; 
    then  
        return 0;
    fi
    return 1;
}

function getFileNameWithoutExt() {
    local absFilePath=$1
    local fullFileName=$(basename -- "${absFilePath}");
    echo "${fullFileName%.*}";
}

function getFileExtension() {
    local absFilePath=$1;
    echo "${absFilePath##*.}";
}

function checkCommandAvailability() {
    local cmdToCheck=$1
    if ! [ -x "$(command -v ${cmdToCheck})"  ]; then
        echo "Error: ${cmdToCheck} is not installed." >&2
        exit 1
    fi
}

function uncompress() {
    local fileToUncompress=$1;
    local fileExt=$(getFileExtension ${fileToUncompress});
    local fileName=$(getFileNameWithoutExt ${fileToUncompress});
    #mkdir -p ~/Downloads/${fileExt};
    for ((i=0; i <${#SUPPORTED_COMPRESSED_TYPES[@]}; ++i)); do
        local ext=${SUPPORTED_COMPRESSED_TYPES[i]}
        local cmd=${UNCOMPRESS_COMMANDS[i]}
        if [[ "${ext}" == *"${fileExt}" ]]; then
            if [ "${ext}" = "zip" ]; then
                checkCommandAvailability "unzip";
                eval ${cmd} ${fileToUncompress} -d ${BASE_DIR} # -d ~/Downloads/${fileExt};
            else
                eval ${cmd} ${fileToUncompress} -C ${BASE_DIR} # -C ~/Downloads/${fileExt};
            fi
        fi
    done;
    # if already exist, remove its content first
    [[ -d "${BASE_DIR}/${SOURCE_FOLDER_NAME}" ]] && rm -rf ${BASE_DIR}/${SOURCE_FOLDER_NAME} 
    mv -f ${BASE_DIR}/${fileName} ${BASE_DIR}/${SOURCE_FOLDER_NAME}

    echo "${GREEN_SETTER}Source folder prepared ${BOLD_SETTER}SUCCESSFULLY${COLOR_RESET}";
}

# ToDo: source has to be removed after use to ensure latest
function processSource() {
    echo "${GREEN_SETTER}Processing, please hold...${COLOR_RESET}"
    if [ -d ${DEFAULT_SOURCE_DIR} ]; then
        return 0;
    fi
    if [ ! -f ${DEFAULT_SOURCE_DIR} ]; then
        exitWithMsg 1 "Source folder/file not found at ${DEFAULT_SOURCE_DIR}"
    fi
    echo "Compressed file ${DEFAULT_SOURCE_DIR} found, we need to uncompress it first."
    uncompress ${DEFAULT_SOURCE_DIR}
}

# the entry of the script;
function main() {
    updateDefaultValue DEFAULT_SOURCE_DIR
    processSource;
    updateDefaultValue ANSIBLE_MULTI_DIR
    setLatestValidVersion;
    copyTheMainYml ${LATEST_VALID_VERSION};
    updateDefaultValue DEFAULT_PEM_DIR
    copyPemFiles 
    configureAnsibleCfg
    updateVersionInConst
    finalValidate
}

[[ -v DEBUG_MODE ]] || main "${@}";

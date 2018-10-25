#!/bin/bash

DEBUG_MODE=1

source auto-generate.sh

function testUncompress() {
    uncompress "/home/hearen/Downloads/operation-tool-deploy-script-develop-e54761b87eb00f9c9d45da6ab80100ee5ce6c596.tar";
    #uncompress "/home/hearen/Downloads/operation-tool-deploy-script-develop-e54761b87eb00f9c9d45da6ab80100ee5ce6c596.tar.gz";
    #uncompress "/home/hearen/Downloads/operation-tool-deploy-script-develop-e54761b87eb00f9c9d45da6ab80100ee5ce6c596.tar.bz2";
    #uncompress "/home/hearen/Downloads/operation-tool-deploy-script-develop-e54761b87eb00f9c9d45da6ab80100ee5ce6c596.zip";
}

#testUncompress;

#showHelp;

#copyTheMainYml "18";

#getLatestValidVersion;

getValueByKeyInConst "AWS_WORK_TERMINAL_KEYPAIR"
getValueByKeyInConst "AWS_GENERAL_KEYPAIR"
getValueByKeyInConst "AWS_GENEAL_KEYPAIR"



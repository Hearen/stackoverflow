package io;

public class PrettifyReturn {
    public static void main(String... args) {
        String raw = "Failed to connect to the host via ssh: OpenSSH_7.2p2 Ubuntu-4ubuntu2.4, OpenSSL 1.0.2g  1 Mar 2016\\r\\ndebug1: Reading configuration data /etc/ssh/ssh_config\\r\\ndebug1: /etc/ssh/ssh_config line 19: Applying options for *\\r\\ndebug1: auto-mux: Trying existing master\\r\\ndebug1: Control socket \\\"/home/hearen/.ansible/cp/6b19fb9a57\\\" does not exist\\r\\ndebug2: resolving \\\"172.26.131.131\\\" port 22\\r\\ndebug2: ssh_connect_direct: needpriv 0\\r\\ndebug1: Connecting to 172.26.131.131 [172.26.131.131] port 22.\\r\\ndebug2: fd 3 setting O_NONBLOCK\\r\\ndebug1: fd 3 clearing O_NONBLOCK\\r\\ndebug1: Connection established.\\r\\ndebug3: timeout: 10000 ms remain after connect\\r\\ndebug1: identity file /home/hearen/.ssh/id_rsa type 1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_rsa-cert type -1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_dsa type -1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_dsa-cert type -1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_ecdsa type -1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_ecdsa-cert type -1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_ed25519 type -1\\r\\ndebug1: key_load_public: No such file or directory\\r\\ndebug1: identity file /home/hearen/.ssh/id_ed25519-cert type -1\\r\\ndebug1: Enabling compatibility mode for protocol 2.0\\r\\ndebug1: Local version string SSH-2.0-OpenSSH_7.2p2 Ubuntu-4ubuntu2.4\\r\\ndebug1: Remote protocol version 2.0, remote software version OpenSSH_6.6.1p1 Ubuntu-2ubuntu2.8\\r\\ndebug1: match: OpenSSH_6.6.1p1 Ubuntu-2ubuntu2.8 pat OpenSSH_6.6.1* compat 0x04000000\\r\\ndebug2: fd 3 setting O_NONBLOCK\\r\\ndebug1: Authenticating to 172.26.131.131:22 as 'hearen'\\r\\ndebug3: hostkeys_foreach: reading file \\\"/home/hearen/.ssh/known_hosts\\\"\\r\\ndebug3: record_hostkey: found key type ECDSA in file /home/hearen/.ssh/known_hosts:13\\r\\ndebug3: load_hostkeys: loaded 1 keys from 172.26.131.131\\r\\ndebug3: order_hostkeyalgs: prefer hostkeyalgs: ecdsa-sha2-nistp256-cert-v01@openssh.com,ecdsa-sha2-nistp384-cert-v01@openssh.com,ecdsa-sha2-nistp521-cert-v01@openssh.com,ecdsa-sha2-nistp256,ecdsa-sha2-nistp384,ecdsa-sha2-nistp521\\r\\ndebug3: send packet: type 20\\r\\ndebug1: SSH2_MSG_KEXINIT sent\\r\\ndebug3: receive packet: type 20\\r\\ndebug1: SSH2_MSG_KEXINIT received\\r\\ndebug2: local client KEXINIT proposal\\r\\ndebug2: KEX algorithms: curve25519-sha256@libssh.org,ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521,diffie-hellman-group-exchange-sha256,diffie-hellman-group-exchange-sha1,diffie-hellman-group14-sha1,ext-info-c\\r\\ndebug2: host key algorithms: ecdsa-sha2-nistp256-cert-v01@openssh.com,ecdsa-sha2-nistp384-cert-v01@openssh.com,ecdsa-sha2-nistp521-cert-v01@openssh.com,ecdsa-sha2-nistp256,ecdsa-sha2-nistp384,ecdsa-sha2-nistp521,ssh-ed25519-cert-v01@openssh.com,ssh-rsa-cert-v01@openssh.com,ssh-ed25519,rsa-sha2-512,rsa-sha2-256,ssh-rsa\\r\\ndebug2: ciphers ctos: chacha20-poly1305@openssh.com,aes128-ctr,aes192-ctr,aes256-ctr,aes128-gcm@openssh.com,aes256-gcm@openssh.com,aes128-cbc,aes192-cbc,aes256-cbc,3des-cbc\\r\\ndebug2: ciphers stoc: chacha20-poly1305@openssh.com,aes128-ctr,aes192-ctr,aes256-ctr,aes128-gcm@openssh.com,aes256-gcm@openssh.com,aes128-cbc,aes192-cbc,aes256-cbc,3des-cbc\\r\\ndebug2: MACs ctos: umac-64-etm@openssh.com,umac-128-etm@openssh.com,hmac-sha2-256-etm@openssh.com,hmac-sha2-512-etm@openssh.com,hmac-sha1-etm@openssh.com,umac-64@openssh.com,umac-128@openssh.com,hmac-sha2-256,hmac-sha2-512,hmac-sha1\\r\\ndebug2: MACs stoc: umac-64-etm@openssh.com,umac-128-etm@openssh.com,hmac-sha2-256-etm@openssh.com,hmac-sha2-512-etm@openssh.com,hmac-sha1-etm@openssh.com,umac-64@openssh.com,umac-128@openssh.com,hmac-sha2-256,hmac-sha2-512,hmac-sha1\\r\\ndebug2: compression ctos: zlib@openssh.com,zlib,none\\r\\ndebug2: compression stoc: zlib@openssh.com,zlib,none\\r\\ndebug2: languages ctos: \\r\\ndebug2: languages stoc: \\r\\ndebug2: first_kex_follows 0 \\r\\ndebug2: reserved 0 \\r\\ndebug2: peer server KEXINIT proposal\\r\\ndebug2: KEX algorithms: curve25519-sha256@libssh.org,ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521,diffie-hellman-group-exchange-sha256,diffie-hellman-group-exchange-sha1,diffie-hellman-group14-sha1,diffie-hellman-group1-sha1\\r\\ndebug2: host key algorithms: ssh-rsa,ssh-dss,ecdsa-sha2-nistp256,ssh-ed25519\\r\\ndebug2: ciphers ctos: aes128-ctr,aes192-ctr,aes256-ctr,arcfour256,arcfour128,aes128-gcm@openssh.com,aes256-gcm@openssh.com,chacha20-poly1305@openssh.com,aes128-cbc,3des-cbc,blowfish-cbc,cast128-cbc,aes192-cbc,aes256-cbc,arcfour,rijndael-cbc@lysator.liu.se\\r\\ndebug2: ciphers stoc: aes128-ctr,aes192-ctr,aes256-ctr,arcfour256,arcfour128,aes128-gcm@openssh.com,aes256-gcm@openssh.com,chacha20-poly1305@openssh.com,aes128-cbc,3des-cbc,blowfish-cbc,cast128-cbc,aes192-cbc,aes256-cbc,arcfour,rijndael-cbc@lysator.liu.se\\r\\ndebug2: MACs ctos: hmac-md5-etm@openssh.com,hmac-sha1-etm@openssh.com,umac-64-etm@openssh.com,umac-128-etm@openssh.com,hmac-sha2-256-etm@openssh.com,hmac-sha2-512-etm@openssh.com,hmac-ripemd160-etm@openssh.com,hmac-sha1-96-etm@openssh.com,hmac-md5-96-etm@openssh.com,hmac-md5,hmac-sha1,umac-64@openssh.com,umac-128@openssh.com,hmac-sha2-256,hmac-sha2-512,hmac-ripemd160,hmac-ripemd160@openssh.com,hmac-sha1-96,hmac-md5-96\\r\\ndebug2: MACs stoc: hmac-md5-etm@openssh.com,hmac-sha1-etm@openssh.com,umac-64-etm@openssh.com,umac-128-etm@openssh.com,hmac-sha2-256-etm@openssh.com,hmac-sha2-512-etm@openssh.com,hmac-ripemd160-etm@openssh.com,hmac-sha1-96-etm@openssh.com,hmac-md5-96-etm@openssh.com,hmac-md5,hmac-sha1,umac-64@openssh.com,umac-128@openssh.com,hmac-sha2-256,hmac-sha2-512,hmac-ripemd160,hmac-ripemd160@openssh.com,hmac-sha1-96,hmac-md5-96\\r\\ndebug2: compression ctos: none,zlib@openssh.com\\r\\ndebug2: compression stoc: none,zlib@openssh.com\\r\\ndebug2: languages ctos: \\r\\ndebug2: languages stoc: \\r\\ndebug2: first_kex_follows 0 \\r\\ndebug2: reserved 0 \\r\\ndebug1: kex: algorithm: curve25519-sha256@libssh.org\\r\\ndebug1: kex: host key algorithm: ecdsa-sha2-nistp256\\r\\ndebug1: kex: server->client cipher: chacha20-poly1305@openssh.com MAC: <implicit> compression: zlib@openssh.com\\r\\ndebug1: kex: client->server cipher: chacha20-poly1305@openssh.com MAC: <implicit> compression: zlib@openssh.com\\r\\ndebug3: send packet: type 30\\r\\ndebug1: expecting SSH2_MSG_KEX_ECDH_REPLY\\r\\ndebug3: receive packet: type 31\\r\\ndebug1: Server host key: ecdsa-sha2-nistp256 SHA256:FVu06+0n46cuB0LeF4i6HokkoVcbSLHT4GiKADmTnkM\\r\\ndebug3: hostkeys_foreach: reading file \\\"/home/hearen/.ssh/known_hosts\\\"\\r\\ndebug3: record_hostkey: found key type ECDSA in file /home/hearen/.ssh/known_hosts:13\\r\\ndebug3: load_hostkeys: loaded 1 keys from 172.26.131.131\\r\\ndebug1: Host '172.26.131.131' is known and matches the ECDSA host key.\\r\\ndebug1: Found key in /home/hearen/.ssh/known_hosts:13\\r\\ndebug3: send packet: type 21\\r\\ndebug2: set_newkeys: mode 1\\r\\ndebug1: rekey after 134217728 blocks\\r\\ndebug1: SSH2_MSG_NEWKEYS sent\\r\\ndebug1: expecting SSH2_MSG_NEWKEYS\\r\\ndebug3: receive packet: type 21\\r\\ndebug2: set_newkeys: mode 0\\r\\ndebug1: rekey after 134217728 blocks\\r\\ndebug1: SSH2_MSG_NEWKEYS received\\r\\ndebug2: key: /home/hearen/.ssh/id_rsa (0x564da5d61ff0), agent\\r\\ndebug2: key: /home/hearen/.ssh/id_dsa ((nil))\\r\\ndebug2: key: /home/hearen/.ssh/id_ecdsa ((nil))\\r\\ndebug2: key: /home/hearen/.ssh/id_ed25519 ((nil))\\r\\ndebug3: send packet: type 5\\r\\ndebug3: receive packet: type 6\\r\\ndebug2: service_accept: ssh-userauth\\r\\ndebug1: SSH2_MSG_SERVICE_ACCEPT received\\r\\ndebug3: send packet: type 50\\r\\ndebug3: receive packet: type 51\\r\\ndebug1: Authentications that can continue: publickey,password\\r\\ndebug3: start over, passed a different list publickey,password\\r\\ndebug3: preferred gssapi-with-mic,gssapi-keyex,hostbased,publickey\\r\\ndebug3: authmethod_lookup publickey\\r\\ndebug3: remaining preferred: ,gssapi-keyex,hostbased,publickey\\r\\ndebug3: authmethod_is_enabled publickey\\r\\ndebug1: Next authentication method: publickey\\r\\ndebug1: Offering RSA public key: /home/hearen/.ssh/id_rsa\\r\\ndebug3: send_pubkey_test\\r\\ndebug3: send packet: type 50\\r\\ndebug2: we sent a publickey packet, wait for reply\\r\\ndebug3: receive packet: type 51\\r\\ndebug1: Authentications that can continue: publickey,password\\r\\ndebug1: Trying private key: /home/hearen/.ssh/id_dsa\\r\\ndebug3: no such identity: /home/hearen/.ssh/id_dsa: No such file or directory\\r\\ndebug1: Trying private key: /home/hearen/.ssh/id_ecdsa\\r\\ndebug3: no such identity: /home/hearen/.ssh/id_ecdsa: No such file or directory\\r\\ndebug1: Trying private key: /home/hearen/.ssh/id_ed25519\\r\\ndebug3: no such identity: /home/hearen/.ssh/id_ed25519: No such file or directory\\r\\ndebug2: we did not send a packet, disable method\\r\\ndebug1: No more authentication methods to try.\\r\\nPermission denied (publickey,password).\\r\\n";
        raw = raw.replaceAll("\\\\r", "");
        raw = raw.replaceAll("\\\\n", "\n");
        System.out.println(raw);
    }
}

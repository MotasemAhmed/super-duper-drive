package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {

    private final CredentialMapper credentialMapper;

    public void updateCredential(Credential credential) {
        credentialMapper.updateCredential(credential);
    }

    public int createCredential(Credential credential) {
        return credentialMapper.insertCredential(credential);
    }

    public void deleteCredential(int credentialId) {
        credentialMapper.deleteCredential(credentialId);
    }

    public List<Credential> getCredentials(int userid) {
        return credentialMapper.getCredentials(userid);
    }

    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

}

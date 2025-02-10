package com.jasonz.designpattern.structuralPatterns.facade.dealwithLegacyCode;

public class FacadeUserService {
    private final LegacyUserAuthenticator authenticator;
    private final LegacyUserAuthorizer authorizer;
    private final LegacyUserProfile profile;

    public FacadeUserService() {
        authenticator = new LegacyUserAuthenticator();
        authorizer = new LegacyUserAuthorizer();
        profile = new LegacyUserProfile();
    }

    public void login(String username, String password) {
        if (authenticator.authenticate(username, password)) {
            if (authorizer.authorize(username, "USER")) {
                profile.loadProfile(username);
            }
        }
    }
}

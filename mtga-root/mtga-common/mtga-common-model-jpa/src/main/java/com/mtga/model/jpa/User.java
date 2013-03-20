package com.mtga.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class that wraps Spring Social Security's DB class
 * @author mbmartinez
 */

@Entity
@Table(name="users")
public class User {
    
    public static final String[] searchableFields = new String[]{"username"};
    
    @Id 
    @GeneratedValue 
    private long id;
    
    @Column(
        nullable=false,
        unique=false,
        name="userId"
    )
    private String username;
    
    @Column(
        nullable=false,
        unique=false
    )
    private String providerId;
    
    @Column(nullable=false)
    private String providerUserId;
    
    @Column
    private Integer rank;
    
    @Column
    private String displayName;
    
    @Column
    private String profileUrl;
    
    @Column
    private String imageUrl;
    
    @Column
    private String accessToken;
    
    @Column
    private String secret;
    
    @Column
    private String refreshToken;
    
    @Column
    private Long expireTime;
    
    @OneToOne(mappedBy="user", fetch=FetchType.EAGER)
    private JpaMtgaPlayer extension;
    
    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JpaMtgaPlayer getExtension() {
        return extension;
    }

    public void setExtension(JpaMtgaPlayer extension) {
        this.extension = extension;
    }

}
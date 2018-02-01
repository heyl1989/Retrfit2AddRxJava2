package cn.v1.retrfit2addrxjava2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qy on 2018/1/31.
 */

public class Contributor {


    /**
     * avatar_url : https://avatars0.githubusercontent.com/u/66577?v=4
     * contributions : 871
     * events_url : https://api.github.com/users/JakeWharton/events{/privacy}
     * followers_url : https://api.github.com/users/JakeWharton/followers
     * following_url : https://api.github.com/users/JakeWharton/following{/other_user}
     * gists_url : https://api.github.com/users/JakeWharton/gists{/gist_id}
     * gravatar_id :
     * html_url : https://github.com/JakeWharton
     * id : 66577
     * login : JakeWharton
     * organizations_url : https://api.github.com/users/JakeWharton/orgs
     * received_events_url : https://api.github.com/users/JakeWharton/received_events
     * repos_url : https://api.github.com/users/JakeWharton/repos
     * site_admin : false
     * starred_url : https://api.github.com/users/JakeWharton/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/JakeWharton/subscriptions
     * type : User
     * url : https://api.github.com/users/JakeWharton
     */

    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("contributions")
    private int contributions;
    @SerializedName("events_url")
    private String eventsUrl;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("gists_url")
    private String gistsUrl;
    @SerializedName("gravatar_id")
    private String gravatarId;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("id")
    private int id;
    @SerializedName("login")
    private String login;
    @SerializedName("organizations_url")
    private String organizationsUrl;
    @SerializedName("received_events_url")
    private String receivedEventsUrl;
    @SerializedName("repos_url")
    private String reposUrl;
    @SerializedName("site_admin")
    private boolean siteAdmin;
    @SerializedName("starred_url")
    private String starredUrl;
    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

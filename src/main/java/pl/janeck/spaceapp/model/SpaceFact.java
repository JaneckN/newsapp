package pl.janeck.spaceapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 23:10
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "date",
        "copyright",
        "explanation",
        "title",
        "url",

})


public class SpaceFact {

    @JsonProperty("id")
    private long id;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("date")
    private String date;
    @JsonProperty("explanation")
    private String explanation;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;

    public SpaceFact(long id, String date, String copyright, String explanation, String title, String url) {
        this.id = id;
        this.date = date;
        this.copyright = copyright;
        this.explanation = explanation;
        this.title = title;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

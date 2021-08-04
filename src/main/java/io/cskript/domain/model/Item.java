package io.cskript.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String title;
	private String htmlTitle;
	private String link;
	private String displayLink;
	private String formattedUrl;
	private String htmlFormattedUrl;
	public Item() {}
	public Item(String title, String htmlTitle, String link, String displayLink, String formattedUrl,
			String htmlFormattedUrl) {
		super();
		this.title = title;
		this.htmlTitle = htmlTitle;
		this.link = link;
		this.displayLink = displayLink;
		this.formattedUrl = formattedUrl;
		this.htmlFormattedUrl = htmlFormattedUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHtmlTitle() {
		return htmlTitle;
	}
	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDisplayLink() {
		return displayLink;
	}
	public void setDisplayLink(String displayLink) {
		this.displayLink = displayLink;
	}
	public String getFormattedUrl() {
		return formattedUrl;
	}
	public void setFormattedUrl(String formattedUrl) {
		this.formattedUrl = formattedUrl;
	}
	public String getHtmlFormattedUrl() {
		return htmlFormattedUrl;
	}
	public void setHtmlFormattedUrl(String htmlFormattedUrl) {
		this.htmlFormattedUrl = htmlFormattedUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [title=").append(title).append(", htmlTitle=").append(htmlTitle).append(", link=")
				.append(link).append(", displayLink=").append(displayLink).append(", formattedUrl=")
				.append(formattedUrl).append(", htmlFormattedUrl=").append(htmlFormattedUrl).append("]");
		return builder.toString();
	}
	
}

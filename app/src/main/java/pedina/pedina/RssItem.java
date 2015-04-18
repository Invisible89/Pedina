package pedina.pedina;

public class RssItem {

    private final String m_title;
    private String m_link;
    private String m_desc;
    private String m_image;

    public RssItem(String title){

        m_title = title;
        m_link = null;
        m_desc = null;
        m_image = null;
    }

    public String getTitle() { return m_title;}

    public String getLink() { return m_link;}

    public String getDescription() { return m_desc;}

    public String getImageUrl() { return m_image;}

    public void setLink(String link) { m_link = link; }
    public void setDescription(String desc) { m_desc = desc; }
    public void setImageUrl(String image) { m_image = image; }



}

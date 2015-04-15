package pedina.pedina;

public class RssItem {

    private final String m_title;
    private final String m_link;
    private final String m_desc;
    private final String m_image;

    public RssItem(String title, String link, String desc, String image){

        m_title = title;
        m_link = link;
        m_desc = desc;
        m_image = image;
    }

    public String getTitle() { return m_title;}

    public String getLink() { return m_link;}

    public String getDescription() { return m_desc;}

    public String getImageUrl() { return m_image;}


}

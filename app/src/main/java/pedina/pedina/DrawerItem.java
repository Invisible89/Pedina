package pedina.pedina;

import android.widget.ImageView;

/**
 * Created by Francesco on 01/05/2015.
 */
public class DrawerItem {

    private final int m_textId;
    private final int m_imageId;

    public DrawerItem(int textId, int imageId)
    {
        m_textId = textId;
        m_imageId = imageId;
    }

    public int getText()
    {
        return m_textId;
    }

    public int getImageId()
    {
        return m_imageId;
    }



}

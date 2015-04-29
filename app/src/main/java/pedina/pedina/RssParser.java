package pedina.pedina;

import android.util.Xml;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Francesco on 11/04/2015.
 */
public class RssParser {
    // We don't use namespaces
    private final String ns = null;

    public List<RssItem> parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            inputStream.close();
        }
    }

    private List<RssItem> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, "rss");
        String title = null;
        String link = null;
        String description = null;
        String image = null;
        RssItem item = null;
        List<RssItem> items = new ArrayList<RssItem>();
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            switch (name)
            {
                case "title":
                {
                    if (item!=null) items.add(item);
                    title = readTitle(parser);
                    item = new RssItem(title);
                    break;
                }
                case "link":
                {
                    link = readLink(parser);
                    if (item!=null) item.setLink(link);
                    break;
                }
                case "description":
                {
                    description = readDescription(parser);
                    if (item!=null) item.setDescription(description);
                    break;
                }
                case "content:encoded":
                {
                    image = readImage(parser);
                    if (item!=null) item.setImageUrl(image);
                    break;
                }
            }
        }
        return items;
    }

    private String readLink(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "link");
        String link = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "link");
        return link;
    }

    private String readTitle(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "title");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "title");
        return title;
    }

    private String readDescription(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "description");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "description");
        return title;
    }

    private String readImage(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "content:encoded");
        String image = null; //parser.getAttributeValue(ns, "url");
        String content_encoded = readText(parser);
        int posImg = content_encoded.indexOf("<img ");
        if (posImg >= 0)
        {
            String img = content_encoded.substring(posImg+5);
            int posSrc = img.indexOf("src=\"");
            if (posSrc>=0)
            {
                String src = img.substring(posSrc+5);
                int posApici = src.indexOf("\"");
                if (posApici>=0)
                    image = src.substring(0,posApici);
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "content:encoded");
        return image;
    }

    // For the tags title and link, extract their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
}
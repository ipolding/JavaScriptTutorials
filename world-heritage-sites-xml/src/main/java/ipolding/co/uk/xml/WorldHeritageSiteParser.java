package ipolding.co.uk.xml;

import ipolding.co.uk.domain.WorldHeritageSite;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WorldHeritageSiteParser {



    static final String outputEncoding = "UTF-8";
    static final String worldHeritageXmlFile = "whc-en.xml";
    static final String name = "site";
    static final String description = "short_description";
    static final String latitude = "latitude";
    static final String longitude = "longitude";




    private Document whsDocument;

    public Document getWhsDocument() throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return this.whsDocument = documentBuilder.parse(new File(worldHeritageXmlFile));
    }

   public List<WorldHeritageSite> getWorldHeritageSite(Document document) throws Exception {
       ArrayList<WorldHeritageSite> worldHeritageSitesList = new ArrayList();
       XPathFactory xPathFactory = XPathFactory.newInstance();
       XPath xpath = xPathFactory.newXPath();
       XPathExpression expr = null;


       for (int i = 1; i <= 981; i++)
           {
               WorldHeritageSite site = new WorldHeritageSite();
               String siteXpath = String.format("//query/row[%d]/", i);
               expr = xpath.compile(siteXpath + name);
               site.setName(expr.evaluate(expr));

//               expr = xpath.compile(siteXpath + description);
//               site.setDescription(expr.evaluate(expr.evaluate(expr)));
//
//               expr = xpath.compile(siteXpath + latitude);
//               site.setLatitude(Double.parseDouble(expr.evaluate(expr.evaluate(expr))));
//
//               expr = xpath.compile(siteXpath + longitude);
//               site.setLongitude(Double.parseDouble(expr.evaluate(expr.evaluate(expr))));
                System.out.println(site.toString());
           }

       return worldHeritageSitesList;

    }
}
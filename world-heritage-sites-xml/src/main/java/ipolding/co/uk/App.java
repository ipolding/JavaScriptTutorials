package ipolding.co.uk;

import ipolding.co.uk.database.WhsSiteDao;
import ipolding.co.uk.domain.WorldHeritageSite;
import ipolding.co.uk.xml.WorldHeritageSiteParser;

import org.skife.jdbi.v2.DBI;
import org.w3c.dom.*;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import java.util.List;

import static ipolding.co.uk.database.DatabaseConfiguration.getH2DatabaseInstance;

public class App
{

    public static void main( String[] args ) throws Exception {
        System.out.println("Hello World!");

////                String siteXpath = "//query/row[1]";
//
//        XPathFactory xPathFactory = XPathFactory.newInstance();
//        XPath xpath = xPathFactory.newXPath();
//        XPathExpression expr = xpath.compile(siteXpath);

        WorldHeritageSiteParser parser = new WorldHeritageSiteParser();
        Document documentWhs = null;
        try {
            documentWhs = parser.getWhsDocument();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        List<WorldHeritageSite> siteList = parser.getWorldHeritageSite(documentWhs);

        DBI dbi = getH2DatabaseInstance();
        WhsSiteDao dao = dbi.open(WhsSiteDao.class);

        for (WorldHeritageSite site : siteList) {
            if (dao.findNameById(!site.getId()))
                dao.insert(site.getId(), site.getName(), site.getDescription(), site.getLatitude(), site.getLongitude());
//            String name = dao.findNameById(1);
//            System.out.print(name);
            System.out.print("Executing");
        }
//        dao.createSiteTable();

        dao.close();
    }
}
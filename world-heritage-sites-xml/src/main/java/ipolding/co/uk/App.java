package ipolding.co.uk;

import ipolding.co.uk.database.WhsSiteDao;
import ipolding.co.uk.domain.WorldHeritageSite;
import ipolding.co.uk.xml.WorldHeritageSiteParser;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.w3c.dom.*;


import javax.sql.DataSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import static com.sun.javafx.fxml.expression.Expression.equalTo;


public class App
{

    public static void main( String[] args ) throws Exception {
        System.out.println("Hello World!");

        // I think i can use this to get a list of each heritage site
        String siteXpath = "//query/row[1]";

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression expr = xpath.compile(siteXpath);

        WorldHeritageSiteParser parser = new WorldHeritageSiteParser();
        Document documentWhs = null;
        try {
            documentWhs = parser.getWhsDocument();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

//        echo(documentWhs);
//        System.out.println(expr.evaluate(documentWhs));

        WorldHeritageSite site = parser.getWorldHeritageSite(documentWhs).get(0);

        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "username",
                "password");

        DBI dbi = new DBI(ds);
        WhsSiteDao dao = dbi.open(WhsSiteDao.class);

        dao.createSiteTable();

        dao.insert(site.getId(), site.getName(), site.getDescription(), site.getLatitude(), site.getLongitude());

        String name = dao.findNameById(1);
        System.out.print(name);

        dao.close();


    }

    static void echo (Node n) {
               final int type = n.getNodeType();
               switch (type) {
                   case Node.DOCUMENT_NODE: System.out.println ("DOC:"); break;
                   case Node.DOCUMENT_TYPE_NODE: System.out.println ("DOC_TYPE:"); break;
                   case Node.ELEMENT_NODE: System.out.println ("ELEM:"); break;
                   case Node.TEXT_NODE: System.out.println ("TEXT:"); break;
                   default:  System.out.print ("other node:  " + type);
                          break;
                   }
               System.out.print (" nodeName=\"" + n.getNodeName() + "\"");
               final String val = n.getNodeValue();
               if (val != null && !(val.trim().equals(""))) {
                      System.out.println (" nodeValue \"" + n.getNodeValue() +"\"");
                   }
               System.out.println ();

               for (Node child = n.getFirstChild(); child !=null; child=child.getNextSibling()) {
                      echo (child);
                   }
            }


}
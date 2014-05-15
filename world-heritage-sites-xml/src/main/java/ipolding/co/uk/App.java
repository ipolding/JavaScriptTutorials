package ipolding.co.uk;

import ipolding.co.uk.xml.WorldHeritageSiteParser;

import org.w3c.dom.*;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;


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

        parser.getWorldHeritageSite(documentWhs);




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
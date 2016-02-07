package uk.ac.ucl.cs.gc01.tutorial5.xmlprocessing;

import java.io.PrintWriter;
import java.util.logging.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import uk.ac.ucl.cs.gc01.tutorial5.javaloggingapis.Logging;

class MyErrorHandler implements ErrorHandler {
	Logger LOGGER = Logger.getLogger(Logging.class.getName());
    PrintWriter out;

    public MyErrorHandler(PrintWriter out) {
        this.out = out;
    }

    public String getParseExceptionInfo(SAXParseException spe) {
        String systemId = spe.getSystemId();
        if (systemId == null) {
            systemId = "null";
        }

        String info = "URI= " + systemId  +"Line: "+ spe.getLineNumber() +
                      ": " + spe.getMessage();
        return info;
    }

    public void warning(SAXParseException spe) throws SAXException {
    	LOGGER.fine(("Warning: " + getParseExceptionInfo(spe)));
    }
        
    public void error(SAXParseException spe) throws SAXException {
        String message = "Error: " + getParseExceptionInfo(spe);
        LOGGER.fine((message));
    }

    public void fatalError(SAXParseException spe) throws SAXException {
        String message = getParseExceptionInfo(spe);
        System.out.println(message);
    }
}
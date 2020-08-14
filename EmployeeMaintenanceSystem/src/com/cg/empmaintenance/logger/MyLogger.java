package com.cg.empmaintenance.logger;

import java.io.FileOutputStream;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;

public class MyLogger {
	static Logger mylogger = Logger.getLogger(MyLogger.class);
	static WriterAppender appender;
	static HTMLLayout layout;

	static {
		try {
			// object of fileoutput stream
			 FileOutputStream fout = new FileOutputStream("logger.html");
			// creating object of SimpleLayout
			layout = new HTMLLayout();
			//appender = new WriterAppender(layout, fout);
			appender = new FileAppender(layout,"logger.html");
			appender.setLayout(layout);
			mylogger.addAppender(appender);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Logger getLoggerInstance() {
		return mylogger;
	}

}

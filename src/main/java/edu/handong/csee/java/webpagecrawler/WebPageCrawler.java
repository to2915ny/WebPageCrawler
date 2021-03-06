package edu.handong.csee.java.webpagecrawler;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class WebPageCrawler {
	
	String path;
	String destination;
	
	boolean help;

	public static void main(String[] args)  {
		
		WebPageCrawler runner = new WebPageCrawler();
		
		runner.run(args);

	}

	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)) {
			if (help){
				printHelp(options);
				return;
			}
		
		
		URLreader read = new URLreader();
		HTMLsave html = new HTMLsave();
		
	
			read.readURL(path);
			html.writeFile(read.getURL(),destination);
		}
	
	}
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			path = cmd.getOptionValue("p");
			destination = cmd.getOptionValue("d");
			
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	/**
	 * This is the Definition Stage where each options are defined
	 * @return
	 */
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("p").longOpt("path")
				.desc("Set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		
		options.addOption(Option.builder("d").longOpt("destination")
				.desc("Set a path of directory to save html file")
				.hasArg()
				.argName("Destination to save")
				.required()
				.build());
		// add options by using OptionBuilder
		

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}
	/**
	 * This method prints out various instruction for clear and easy to use environment for the user
	 * @param options
	 */
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "WebPageCralwer Program";
		String footer ="\nPlease report issues at to2915ny@me.com";
		formatter.printHelp("WebPageCrawler", header, options, footer, true);
	}
}



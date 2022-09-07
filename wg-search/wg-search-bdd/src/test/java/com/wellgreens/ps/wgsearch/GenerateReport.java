package com.wellgreens.ps.wgsearch;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateReport {

    public static void GenerateMasterthoughtReport(){
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("src/test/resources/json/report.json");

        String buildNumber = "1";
        String projectName = "wg-search-bdd";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration - check javadoc for details
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
// do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page


// optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        configuration.addClassificationFiles(classificationFiles);

// optionally specify qualifiers for each of the report json files
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
// and here validate 'result' to decide what to do if report has failed

    }
}

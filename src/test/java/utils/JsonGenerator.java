package utils;

import models.SearchModel;
import models.SearchResultModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JsonGenerator {
    public static String ROOT_FOLDER = System.getProperty("user.dir");


    public static String createConfigs(String webDriverTypeName,long testTime, SearchModel searchModel, ArrayList<SearchResultModel> searchResultModelList) {
        String testReportFileName="Hata var";
        try {
            String tempLocFileName = "Template.json";

            String templateData = readJSONReportFile(tempLocFileName);
            JSONObject configData = new JSONObject(templateData);
            JSONObject resultsData = configData.getJSONObject("result");
           // JSONObject resultsData = (JSONObject) results.get(0);

            resultsData.put("browserName", webDriverTypeName);
            resultsData.put("testTimeMilliSecond", testTime);

            JSONArray categorySearchArray = new JSONArray(searchModel.getCategories());
            resultsData.put("categorySearch", categorySearchArray);

            JSONArray provinceSearchArray = new JSONArray(searchModel.getAddressProvince());
            resultsData.put("provinceSearch", provinceSearchArray);

            JSONArray districtSearchArray = new JSONArray(searchModel.getAddressDistrict());
            resultsData.put("districtSearch", districtSearchArray);

            resultsData.put("video", searchModel.getVideo());
            resultsData.put("photo", searchModel.getPhoto());
            resultsData.put("megaPhoto", searchModel.getMegaPhoto());

            JSONArray searchResult = resultsData.getJSONArray("searchResult");


            for (int i = 0; i < searchResultModelList.size(); i++) {
                SearchResultModel searchResultModel = searchResultModelList.get(i);
                JSONObject searchResultData = new JSONObject();

                searchResultData.put("ilanCategory", searchResultModel.getTabMenuName());

                JSONArray ilanTitleArray = new JSONArray(searchResultModel.getTableTitle());
                searchResultData.put("ilanTitle", ilanTitleArray);

                JSONArray ilanContent1Array = new JSONArray(searchResultModel.getTableContent1());
                searchResultData.put("ilanContent1", ilanContent1Array);

                JSONArray ilanContent2hArray = new JSONArray(searchResultModel.getTableContent2());
                searchResultData.put("ilanContent2", ilanContent2hArray);

                JSONArray ilanContent3Array = new JSONArray(searchResultModel.getTableContent3());
                searchResultData.put("ilanContent3", ilanContent3Array);

                JSONArray ilanContent4hArray = new JSONArray(searchResultModel.getTableContent4());
                searchResultData.put("ilanContent4", ilanContent4hArray);

                JSONArray ilanContent5Array = new JSONArray(searchResultModel.getTableContent5());
                searchResultData.put("ilanContent5", ilanContent5Array);

                searchResult.put(i,searchResultData);
            }

            try {
                Path nodeFolder = Paths.get(ROOT_FOLDER + "\\report");

                if (!Files.exists(nodeFolder))
                    Files.createDirectories(nodeFolder);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmSS");
                Date date = new Date(System.currentTimeMillis());
                String dateNow = formatter.format(date);

                testReportFileName = "TestReport_" + dateNow + ".json";
                FileWriter file = new FileWriter(ROOT_FOLDER + "\\report\\"+testReportFileName);
                file.write(configData.toString());
                file.flush();

            } catch (IOException e) {
                LogUtil.error("File write error:" + e.getMessage());
                e.printStackTrace();
            }

        } catch (JSONException e) {
            LogUtil.error("Json func error:" + e.getMessage());
            e.printStackTrace();
        }

        return testReportFileName;
    }

    public static String readJSONReportFile(String fileName) {
        String fileContent = null;
        String fileLoc = ROOT_FOLDER + "\\report\\"+fileName;
        Path confTempPath = Paths.get(fileLoc);
        if (Files.exists(confTempPath)) {
            // Read JSON template for config.
            try (FileReader reader = new FileReader(fileLoc)) {
                // Read JSON file
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(reader);
                fileContent = obj.toString();
                LogUtil.debug(fileContent);
                LogUtil.otherInfo("Config file read.");
            } catch (IOException | ParseException e) {
                LogUtil.error("File read error:" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            LogUtil.error("File doesnt exist " + fileLoc);
        }

        return fileContent;
    }
}

package models;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultModel {
    private  String tabMenuName;
    private ArrayList<String> tableTitle, tableContent1, tableContent2, tableContent3, tableContent4, tableContent5;

    public SearchResultModel() {
        this.tableTitle = new ArrayList<>();
        this.tableContent1 = new ArrayList<>();
        this.tableContent2 = new ArrayList<>();
        this.tableContent3 = new ArrayList<>();
        this.tableContent4 = new ArrayList<>();
        this.tableContent5 = new ArrayList<>();
    }

    public ArrayList<String> getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(List<WebElement> tableTitleElements) {
        for (WebElement element : tableTitleElements) {
            this.tableTitle.add(element.getText());
        }
    }

    public void setTableContent(int Index, List<WebElement> tableContentElements) {
        switch (Index) {
            case 0:
                for (WebElement element : tableContentElements) {
                    this.tableContent1.add(element.getText());
                }
                break;
            case 1:
                for (WebElement element : tableContentElements) {
                    this.tableContent2.add(element.getText());
                }
                break;
            case 2:
                for (WebElement element : tableContentElements) {
                    this.tableContent3.add(element.getText());
                }
                break;
            case 3:
                for (WebElement element : tableContentElements) {
                    this.tableContent4.add(element.getText());
                }
                break;
            case 4:
                for (WebElement element : tableContentElements) {
                    this.tableContent5.add(element.getText());
                }
                break;
        }

    }

    public void setTableContent(int Index,ArrayList<String> emptyContentItems) {
        switch (Index){
            case 0:
                this.tableContent1.addAll(emptyContentItems);
                break;
            case 1:
                this.tableContent2.addAll(emptyContentItems);
                break;
            case 2:
                this.tableContent3.addAll(emptyContentItems);
                break;
            case 3:
                this.tableContent4.addAll(emptyContentItems);
                break;
            case 4:
                this.tableContent5.addAll(emptyContentItems);
                break;
        }
    }

    public ArrayList<String> getTableContent1() {
        return tableContent1;
    }

    public ArrayList<String> getTableContent2() {
        return tableContent2;
    }

    public ArrayList<String> getTableContent3() {
        return tableContent3;
    }

    public ArrayList<String> getTableContent4() {
        return tableContent4;
    }

    public ArrayList<String> getTableContent5() {
        return tableContent5;
    }

    public String getTabMenuName() {
        return tabMenuName;
    }

    public void setTabMenuName(String tabMenuName) {
        this.tabMenuName = tabMenuName;
    }
}

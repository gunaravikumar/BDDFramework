package com.reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepository {

    //Login Page
    public static String loginUserName = "input[id$='_Username']";
    public static String loginPassword = "input[id$='_Password']";
    public static String loginButton = "input[id$='_LoginButton']";

    //Domain Management Page
    public static String userHomeFrame = "UserHomeFrame";
    public static String titleDomainManagement = "div[title='Domain Management']";
    public static String tabContentFrame = "iframe[id='TabContent']";
    public static String newDomainButton = "input[name='NewDomainButton']";
    public static String deleteDomainButton = "input[name='DeleteDomainButton']";
    public static String confirmDialog = "span[id$='ConfirmationCaption']";
    public static String confirmOkButton = "input[name$='ConfirmButton'][value='OK']";
    public static String domainListTable = "//*[@id='m_domainListControl_m_dataListGrid']/tbody/tr/td[1]/span";

    //New Domain Creation Page
    public static String pageTitleLabel = "span[id='ctl00_MasterContentPlaceHolder_Label1']";
    public static String domainNameTextBox = "input[id$='DomainInfo_Name']";
    public static String domainDescTextBox = "input[id$='DomainInfo_Description']";
    public static String receivingInstTextBox = "input[id$='DomainInfo_ReceivingInstitution'";
    public static String dataSourceDisConnectedBox = "select[id$='DataSourceDisconnectedListBox']";
    public static String connectButton = "input[id$='DataInfo_ConnectDataSource']";
    public static String userIDTextBox = "input[id$='UserInfo_UserID']";
    public static String userLNameTextBox = "input[id$='UserInfo_LastName']";
    public static String userFNameTextBox = "input[id$='UserInfo_FirstName']";
    public static String userPasswordTextBox = "input[id$='UserInfo_Password']";
    public static String userConfirmPasswordTextBox = "input[id$='UserInfo_ComparisonPassword']";
    public static String roleNameTextBox = "input[id$='RoleAccessFilter_Name']";
    public static String roleDescTextBox = "input[id$='RoleAccessFilter_Description']";
    public static String saveButton = "input[value='Save']";

    //Role Creation Page
    public static String roleManagementTab = "div[title='Role Management']";
    public static String newRoleButton = "input[id='NewRoleButton']";
    public static String domainNameDropDown = "select[id$='DomainDropDown_NameDropDownList']";
    public static String useDomainSettingCheckBox =  "input[id$='UseDomainToolbarCheckbox']";
    public static String toolConfiguration = "div[id='toolbarItemsConfig']";
    public static String roleListTable = "//*[@id='m_roleListControl_m_dataListGrid']/tbody/tr/td[1]/span";

    //Studies Page
    public static String studiesTab = "div[title='Studies']";
    public static String patientIDTextBox = "input[name$='searchInputPatientID']";
    public static String searchButton = "input[id$='m_searchButton']";
    public static String enterpriseButton = "input#m_enterpriseViewStudyButton";
    public static String serverForm = "form#ServerForm";
    public static String studyBannerText = "span#m_studyPanels_m_studyPanel_1_PatientBannerControl_patientBannerText";
    public static String studyPanel = "div#m_studyPanels_m_studyPanel_1_studyPanel";
    public static String thumbnailContent = "div#m_studyPanels_m_studyPanel_1_thumbnailContent";
    public static String thumbnailPRModality = "div#ModalityDivPR";
    public static String thumbnailMGModality = "div#ModalityDivMG";
    public static String seriesViewer1 = "img#m_studyPanels_m_studyPanel_1_ctl03_SeriesViewer_1_1_viewerImg";
    public static String seriesViewer2 = "img#m_studyPanels_m_studyPanel_1_ctl03_SeriesViewer_1_2_viewerImg";
    public static String seriesViewer3 = "img#m_studyPanels_m_studyPanel_1_ctl03_SeriesViewer_2_1_viewerImg";
    public static String seriesViewer4 = "img#m_studyPanels_m_studyPanel_1_ctl03_SeriesViewer_2_2_viewerImg";
}

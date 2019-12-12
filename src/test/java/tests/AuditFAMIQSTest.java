package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;


public class AuditFAMIQSTest extends TestBase {

    public AuditFAMIQSTest() throws IOException {
        PageFactory.initElements(driver, this);
    }



    @Test(priority = 1, alwaysRun = true)
    public void CanAddAuditFAMIQS(Method method) throws IOException,  InterruptedException {


        // Acceder à la menu Audit Organisations

        WebElement organisationButton = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/a"));
        organisationButton.click();
        WebElement OrganisationProfile = driver.findElement(By.xpath("//a[contains(text(),'Test Auto org')]"));
        OrganisationProfile.click();

        WebElement auditMenu = driver.findElement(By.xpath("//a[title('Audits')"));
        auditMenu.click();

        // Ajouter Audit

        WebElement AddAuditButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]"));

        Thread.sleep(3000);
        try {
            AddAuditButton.click();
        } catch (Exception e) {
            AddAuditButton.click();
        }
        //AddAuditButton.click();

        WebElement CreateAuditButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/div[1]/form[1]/div[2]/button[1]"));

        try {
            CreateAuditButton.click();
        } catch (Exception e) {
            CreateAuditButton.click();
        }
        //CreateAuditButton.click();


        WebElement AuditTitleFAMIQS = driver.findElement(By.xpath("//*[@id='edit-title-0-value']"));
        AuditTitleFAMIQS.clear();
        AuditTitleFAMIQS.sendKeys("Audit FAMI-QS Automation");


        WebElement CheckBoxFamiQsAudit = driver.findElement(By.xpath("//input[@id='edit-field-au-ref-no-2426807']"));
        CheckBoxFamiQsAudit.click();

        WebElement ButtonSaveAuditFamiQs = driver.findElement(By.xpath("//*[@id='edit-submit']"));
        try {
            ButtonSaveAuditFamiQs.click();
        } catch (Exception e) {
            ButtonSaveAuditFamiQs.click();
        }
        //ButtonSaveAuditFamiQs.click();
    }
    @Test(priority = 2, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanEditProfileOrgAuditFAMIQS(Method method) throws IOException {
        // Edit Profile Organisation
        goToAuditFamiQSMenu();

        WebElement profileOrgMenu = driver.findElement(By.xpath("//a[contains(text(),'Organisation profile')]"));
        profileOrgMenu.click();

        WebElement profileOrgEdit = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));

        try {
            profileOrgEdit.click();
        } catch (Exception e) {
            profileOrgEdit.click();
        }


        WebElement editorFrameDescrpOrg = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));

        driver.switchTo().frame(editorFrameDescrpOrg);

        WebElement bodyDescrpOrg = driver.findElement(By.tagName("body"));

        bodyDescrpOrg.clear();
        bodyDescrpOrg.sendKeys("some text");

        driver.switchTo().defaultContent();

        //WebElement DescrpOrg = driver.findElement(By.id("edit-field-pro-fmq-general-descriptio-0-value"));
        //DescrpOrg.sendKeys("Test Automation");

        WebElement OffsiteAct = driver.findElement(By.id("edit-field-pro-fmq-off-site-actitivie-0-value"));
        OffsiteAct.sendKeys("Test Automation");

        WebElement ftenumber = driver.findElement(By.id("edit-field-pro-fmq-number-of-fte-0-value"));
        ftenumber.sendKeys("1");

        WebElement signchanges = driver.findElement(By.id("edit-field-pro-fmq-significant-chang-0-value"));
        signchanges.sendKeys("Test Automation");

        WebElement profileOrgSave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        profileOrgSave.click();
    }

    @Test(priority = 3, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanEditDetailsAuditFAMIQS(Method method) throws IOException {

        // Edit Details
        goToAuditFamiQSMenu();

        WebElement DetailsMenu = driver.findElement(By.xpath("//a[contains(text(),'Details')]"));
        DetailsMenu.click();

        WebElement DetailsEdit = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
        DetailsEdit.click();

        WebElement editorFrameDescStatement = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));

        driver.switchTo().frame(editorFrameDescStatement);

        WebElement bodyDescStatement = driver.findElement(By.tagName("body"));

        bodyDescStatement.clear();
        bodyDescStatement.sendKeys("some text");

        driver.switchTo().defaultContent();

        //WebElement DescStatement = driver.findElement(By.id("edit-field-pra-fmq-disclaimer-stateme-0-value"));
        //DescStatement.sendKeys("Test Automation");

        Select DrpAuditStage = new Select(driver.findElement(By.id("edit-field-pra-fmq-audit-stage")));
        DrpAuditStage.selectByVisibleText("Initial - stage 1");

        WebElement CheckBoxActivity = driver.findElement(By.xpath("//input[@id='edit-field-pra-fmq-activity-1']"));
        CheckBoxActivity.click();

        WebElement CheckBoxProcess = driver.findElement(By.xpath("//input[@id='edit-field-pra-fmq-processe-1']"));
        CheckBoxProcess.click();

        WebElement CheckBoxScope = driver.findElement(By.xpath("//input[@id='edit-field-pra-fmq-category-2498051']"));
        CheckBoxScope.click();

        WebElement CheckOtherStandard = driver
                .findElement(By.xpath("//input[@id='edit-field-pra-fmq-other-standard-0']"));
        CheckOtherStandard.click();

        WebElement NmbrIngPurch = driver.findElement(By.id("edit-field-pra-fmq-number-of-ingred-0-value"));
        NmbrIngPurch.sendKeys("1");

        WebElement AddSiteOperating = driver.findElement(By.id("edit-field-pra-fmq-additional-site-0-value"));
        AddSiteOperating.sendKeys("1");

        WebElement OnSiteMandays = driver.findElement(By.id("edit-field-pra-fmq-on-site-audit-dur-0-value"));
        OnSiteMandays.sendKeys("1");

        WebElement OnSitereduction = driver.findElement(By.id("edit-field-pra-fmq-on-site-audit-time-0-value"));
        OnSitereduction.sendKeys("1");

        WebElement ActiveSub = driver.findElement(By.id("edit-field-pra-fmq-ingredient-0-as"));
        ActiveSub.sendKeys("Test Automation");

        WebElement CheckProdProcess = driver
                .findElement(By.xpath("//input[@id='edit-field-pra-fmq-ingredient-0-bioprocess']"));
        CheckProdProcess.click();

        WebElement MixName = driver.findElement(By.id("edit-field-pra-fmq-mixture-0-cpn"));
        MixName.sendKeys("Test Automation");

        WebElement CheckFunctionality = driver
                .findElement(By.xpath("//input[@id='edit-field-pra-fmq-mixture-0-technological']"));
        CheckFunctionality.click();

        WebElement FormationName = driver.findElement(By.id("edit-field-pra-fmq-formulation-0-cpn"));
        FormationName.sendKeys("Test Automation");

        WebElement CheckFormulation = driver
                .findElement(By.xpath("//input[@id='edit-field-pra-fmq-formulation-0-technological']"));
        CheckFormulation.click();

        WebElement editorFrame = driver.findElement(By.xpath("//*[@id=\"cke_2_contents\"]/iframe"));

        driver.switchTo().frame(editorFrame);

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear();
        body.sendKeys("some text");

        driver.switchTo().defaultContent();

        WebElement DetailsSave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        DetailsSave.click();
    }

    @Test(priority = 4, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanEditDatesAndOrgAuditFAMIQS(Method method) throws IOException {
        // Edit Dates & Organisations
        goToAuditFamiQSMenu();
        WebElement DatesMenu = driver.findElement(By.xpath("//a[contains(text(),'Dates & organisation')]"));
        DatesMenu.click();

        WebElement DatesEdit = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
        DatesEdit.click();

        WebElement AuditProg = driver.findElement(By.id("edit-field-pla-fmq-audit-programme-pl-0-value"));
        AuditProg.sendKeys("Test Automation");

        WebElement AuditPlace = driver.findElement(By.id("edit-field-pla-fmq-audit-place-0-value"));
        AuditPlace.sendKeys("Test Automation");

        WebElement DateSave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        DateSave.click();
    }
    @Test(priority = 5, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanEditTeamAndAuditeAuditFAMIQS(Method method) throws IOException  {
        // Edit Team & Auditees
        goToAuditFamiQSMenu();

        WebElement TeamMenu = driver.findElement(By.xpath("//a[contains(text(),'Audit team & Auditees')]"));
        TeamMenu.click();

		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Edit')]")));*/
        WebElement TeamEdit = driver.findElement(By.partialLinkText("Edit"));

        try {
            TeamEdit.click();
        } catch (Exception e) {
            TeamEdit.click();
        }

        WebElement CheckAuditors = driver.findElement(By.xpath("//input[@id='edit-field-eqp-ref-prf-2475289']"));
        CheckAuditors.click();

        WebElement AuditeeName = driver.findElement(By.id("edit-field-eqp-auditees-0-name"));
        AuditeeName.sendKeys("Test Automation");

        WebElement AuditeeFunction = driver.findElement(By.id("edit-field-eqp-auditees-0-function"));
        AuditeeFunction.sendKeys("Test Automation");

        WebElement AuditeeCheck = driver.findElement(By.xpath("//input[@id='edit-field-eqp-auditees-0-opening']"));
        AuditeeCheck.click();

        WebElement Accomperson = driver.findElement(By.id("edit-field-eqp-fmq-accompanying-0-value"));
        Accomperson.sendKeys("Test Automation");

        WebElement TeamSave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        TeamSave.click();
    }

    @Test(priority = 6, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanEditGeneralImpAuditFAMIQS(Method method) throws IOException {
        // Edit General Impression
        goToAuditFamiQSMenu();
        WebElement GenImpMenu = driver.findElement(By.xpath("//a[contains(text(),'General impression')]"));
        GenImpMenu.click();

        WebElement GenImpEdit = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
        GenImpEdit.click();

        WebElement editorFrameCapMangSystem = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameCapMangSystem);
        WebElement bodyCapMangSystem = driver.findElement(By.tagName("body"));
        bodyCapMangSystem.clear();
        bodyCapMangSystem.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameContexOrg = driver.findElement(By.xpath("//*[@id=\"cke_2_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameContexOrg);
        WebElement bodyConextOrg = driver.findElement(By.tagName("body"));
        bodyConextOrg.clear();
        bodyConextOrg.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameLeadership = driver.findElement(By.xpath("//*[@id=\"cke_3_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameLeadership);
        WebElement bodyLeadership = driver.findElement(By.tagName("body"));
        bodyLeadership.clear();
        bodyLeadership.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFramePlanning = driver.findElement(By.xpath("//*[@id=\"cke_4_contents\"]/iframe"));
        driver.switchTo().frame(editorFramePlanning);
        WebElement bodyPlanning = driver.findElement(By.tagName("body"));
        bodyPlanning.clear();
        bodyPlanning.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameSupport = driver.findElement(By.xpath("//*[@id=\"cke_5_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameSupport);
        WebElement bodySupport = driver.findElement(By.tagName("body"));
        bodySupport.clear();
        bodySupport.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameOperation = driver.findElement(By.xpath("//*[@id=\"cke_6_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameOperation);
        WebElement bodyOperation = driver.findElement(By.tagName("body"));
        bodyOperation.clear();
        bodyOperation.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameGMP = driver.findElement(By.xpath("//*[@id=\"cke_7_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameGMP);
        WebElement bodyGMP = driver.findElement(By.tagName("body"));
        bodyGMP.clear();
        bodyGMP.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement CheckBoxFamiQsProcessDoc = driver.findElement(By.id("edit-field-ign-fmq-is-the-haccp-plan-1"));
        CheckBoxFamiQsProcessDoc.click();

        WebElement editorFramePlanComment = driver.findElement(By.xpath("//*[@id=\"cke_8_contents\"]/iframe"));
        driver.switchTo().frame(editorFramePlanComment);
        WebElement bodyPlanComment = driver.findElement(By.tagName("body"));
        bodyPlanComment.clear();
        bodyPlanComment.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement CheckBoxHACCPProcess = driver.findElement(By.id("edit-field-ign-fmq-haccp-process-1"));
        CheckBoxHACCPProcess.click();

        WebElement editorFramePerfeval = driver.findElement(By.xpath("//*[@id=\"cke_9_contents\"]/iframe"));
        driver.switchTo().frame(editorFramePerfeval);
        WebElement bodyPerfEval = driver.findElement(By.tagName("body"));
        bodyPerfEval.clear();
        bodyPerfEval.sendKeys("some text");
        driver.switchTo().defaultContent();

        Select Drpfamicrisis = new Select(driver.findElement(By.id("edit-field-field-pra-famiqs-crisis")));
        Drpfamicrisis.selectByVisibleText("Yes");

        WebElement editorFrameInternalAudit = driver.findElement(By.xpath("//*[@id=\"cke_10_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameInternalAudit);
        WebElement bodyInternalAudit = driver.findElement(By.tagName("body"));
        bodyInternalAudit.clear();
        bodyInternalAudit.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameImprovment = driver.findElement(By.xpath("//*[@id=\"cke_11_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameImprovment);
        WebElement bodyImprovment = driver.findElement(By.tagName("body"));
        bodyImprovment.clear();
        bodyImprovment.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameEffctvActions = driver.findElement(By.xpath("//*[@id=\"cke_12_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameEffctvActions);
        WebElement bodyEffctvActions = driver.findElement(By.tagName("body"));
        bodyEffctvActions.clear();
        bodyEffctvActions.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement CCPProcess = driver.findElement(By.id("edit-field-ign-fmq-ccp-0-process"));
        CCPProcess.sendKeys("Test Automation");

        WebElement CCPDesc = driver.findElement(By.id("edit-field-ign-fmq-ccp-0-description"));
        CCPDesc.sendKeys("Test Automation");

        WebElement editorFrameOppImprov = driver.findElement(By.xpath("//*[@id=\"cke_13_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameOppImprov);
        WebElement bodyOppImprov = driver.findElement(By.tagName("body"));
        bodyOppImprov.clear();
        bodyOppImprov.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement GenImpSave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        GenImpSave.click();

    }
    @Test(priority = 7, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanEditConclusionAuditFAMIQS(Method method) throws IOException {
        // Edit Conclusion
        goToAuditFamiQSMenu();
        WebElement ConclusionMenu = driver.findElement(By.xpath("//a[contains(text(),'Conclusions')]"));
        ConclusionMenu.click();

        WebElement ConclusionEdit = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
        ConclusionEdit.click();

        Select DrpAuditConclusion = new Select(driver.findElement(By.id("edit-field-ccs-fmq-audit-conclusion")));
        DrpAuditConclusion.selectByVisibleText("Stage 1 audit to be repeated");

        WebElement ConclusionDesc = driver.findElement(By.id("edit-field-ccs-fmq-conclusion-desc-0-value"));
        ConclusionDesc.sendKeys("Test Automation");

        Select DrpFamiLogo = new Select(driver.findElement(By.id("edit-field-ccs-fmq-use-of-fami-qs-log")));
        DrpFamiLogo.selectByVisibleText("Not applicable");

        WebElement ConclusionSave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        ConclusionSave.click();

    }

    @Test(priority = 8, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanAddFindingFAMIQS(Method method) throws IOException {

        // Acceder à la menu Audit

        goToAuditFamiQSMenu();

        WebElement MenuFinding = driver.findElement(By.xpath("//a[contains(text(),'Audit findings')]"));
        MenuFinding.click();

        WebElement AddFinding = driver.findElement(By.xpath("//a[contains(text(),'Add finding')]"));
        AddFinding.click();

        Select DrpGrading = new Select(driver.findElement(By.id("edit-viasyst-interpretation-2426807")));
        DrpGrading.selectByVisibleText("Minor non-conformity");

        Select DrpClause = new Select(driver.findElement(By.id("edit-viasyst-clause-2426807")));
        DrpClause.selectByVisibleText("5.1 Leadership commitment");

        WebElement CreateFinding = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        CreateFinding.click();

        WebElement EditFinding = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
        EditFinding.click();

        WebElement editorFrameFindingDesc = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameFindingDesc);
        WebElement bodyFindingDesc = driver.findElement(By.tagName("body"));
        bodyFindingDesc.clear();
        bodyFindingDesc.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameFindingCauseAnalysis = driver.findElement(By.xpath("//*[@id=\"cke_2_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameFindingCauseAnalysis);
        WebElement bodyCauseAnalysis = driver.findElement(By.tagName("body"));
        bodyCauseAnalysis.clear();
        bodyCauseAnalysis.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement editorFrameFindingPlanned = driver.findElement(By.xpath("//*[@id=\"cke_3_contents\"]/iframe"));
        driver.switchTo().frame(editorFrameFindingPlanned);
        WebElement bodyPlanned = driver.findElement(By.tagName("body"));
        bodyPlanned.clear();
        bodyPlanned.sendKeys("some text");
        driver.switchTo().defaultContent();

        WebElement Findingsave = driver.findElement(By.xpath("//button[@id='edit-submit']"));
        Findingsave.click();
    }



    @Test(priority = 9, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanValidateAuditLeadAuditorFAMIQS(Method method) throws IOException {

        // Acceder à la menu Audit

        goToAuditFamiQSMenu();

        WebElement ReviewerValidation = driver
                .findElement(By.xpath("//a[contains(text(),'validation by the lead auditor')]"));
        ReviewerValidation.click();



    }


    @Test(priority = 10, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanUnlocktheAuditFAMIQS(Method method) throws IOException {

        // Acceder à la menu Audit

        goToAuditFamiQSMenu();
        WebElement ValidationReviewerMessage = driver.findElement(By.xpath("//a[contains(text(),'Unlock')]"));
        ValidationReviewerMessage.click();



    }

    @Test(priority = 11, dependsOnMethods = {"CanAddAuditFAMIQS"})
    public void CanValidateAuditReviewValidationFAMIQS(Method method) throws IOException {

        // Acceder à la menu Audit

        goToAuditFamiQSMenu();

        WebElement ReviewerValidation = driver.findElement(By.xpath("//a[contains(text(),'Reviewer validation')]"));
        ReviewerValidation.click();



    }




}
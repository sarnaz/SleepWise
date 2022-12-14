package sleepAppGUI.pages.questions.alcohol;

import sleepAppGUI.interaction.*;
import sleepAppGUI.pages.questions.QuestionsPage;

public class AlcoholQuestions extends QuestionsPage {
    @Override
    protected int pageNumber() {
        return 11;
    }

    @Override
    protected void setUp(Page page) {
        super.setUp(page);

        MyImage.putImage(page, new int[] {245, 15}, 100, "alcoholLogo");

        //MyImage yesClicked = new MyImage(page, new int []{325, 230}, new int[] {375, 265}, "yesButton", false);
        //MyImage noClicked = new MyImage(page, new int[] {425, 230}, new int[] {475, 265}, "noButton", false);

        // did you drink alcohol?
        MyText.putTextCentred(page, new int[] {400, 210}, 20, "Have you consumed alcohol?");
        new MyButton(page, "yes", new int[] {325, 230}, new int[] {375, 265}, "yesUnclicked") {
            public void isClicked() {
                AlcoholQuestions.this.push(new AlcoholYes());
                System.out.println("yes");

            }
        };
        new MyButton(page, "no", new int[] {425, 230}, new int[] {475, 265}, "noUnclicked")
        {
            public void isClicked()
            {
                AlcoholQuestions.this.push(new AlcoholNo());
                System.out.println("no");
            }
        };
    }
}

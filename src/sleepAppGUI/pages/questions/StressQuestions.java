package sleepAppGUI.pages.questions;

import sleepAppDatabase.Database;
import sleepAppGUI.interaction.*;
import sleepAppGUI.pages.HomePage;

public class StressQuestions extends QuestionsPage {
    @Override
    protected int pageNumber() {
        return 14;
    }

    @Override
    protected void setUp(Page page) {
        super.setUp(page);

        MyImage stressLogo = new MyImage(page, new int[] {185, 15}, new int[] {330, 160}, "stressLogo", true);
        // daily stress
        MyText dailyStress = new MyText(page, new int[] {195, 260}, new int[] {220, 280}, "Rate your average stress level today (1-5):");
        MyTextField averageStress = new MyTextField(main, page, new int[] {380, 280}, new int[] {420, 305});
        // Add next button
        MyButton nextButton = new MyButton(page, "next", new int[] {360, 400}, new int[] {440, 445}, "next")
        {
            public void isClicked()
            {
                Object[][] factors_chosen = Database.getFactorArray();
                if ((Boolean) factors_chosen[1][4]){
                    StressQuestions.this.push(new WaterQuestions());
                }
                else if ((Boolean) factors_chosen[1][5]){
                    StressQuestions.this.push(new ScreenTimeQuestions());
                }
                else{
                    StressQuestions.this.push(new HomePage());
                }
            }
        };
    }
}

package sleepAppGUI.pages.questions.alcohol;

import sleepAppDatabase.Database;
import sleepAppGUI.interaction.*;
import sleepAppGUI.pages.HomePage;
import sleepAppGUI.pages.questions.ScreenTimeQuestions;
import sleepAppGUI.pages.questions.StressQuestions;
import sleepAppGUI.pages.questions.WaterQuestions;
import sleepAppGUI.pages.questions.exercise.ExerciseQuestions;

import java.util.Calendar;
import java.util.Date;

public class AlcoholYes extends AlcoholQuestions {

    @Override
    protected int pageNumber() {
        return 12;
    }

    @Override
    protected void setUp(Page page) {
        super.setUp(page);

        MyImage yesClicked = new MyImage(page, new int []{325, 230}, new int[] {375, 265}, "yesButton", true);
        page.pushToFront(yesClicked);
        MyText.putTextCentred(page, new int[] {400, 290}, 20, "How many units have you had?");
        MyTextField howMany = new MyTextField(main, page, new int[] {380, 305}, new int[] {420, 330});
        new MyButton(page, "next", new int[] {360, 400}, new int[] {440, 445}, "next") {
            public void isClicked()
            {
                boolean valid = true;
                int units = 0;
                try{
                    units = Integer.parseInt(howMany.getText());
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid");
                    valid = false;
                }
                if (valid) {
                    // write to DB here!
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH) + 1;
                    int date = calendar.get(Calendar.DAY_OF_MONTH);
                    Database.addAlcoholEntry(units, date, month, year);
                    Object[][] factors_chosen = Database.getFactorArray();
                    if ((Boolean) factors_chosen[1][2]) {
                        AlcoholYes.this.push(new ExerciseQuestions());
                    } else if ((Boolean) factors_chosen[1][3]) {
                        AlcoholYes.this.push(new StressQuestions());
                    } else if ((Boolean) factors_chosen[1][4]) {
                        AlcoholYes.this.push(new WaterQuestions());
                    } else if ((Boolean) factors_chosen[1][5]) {
                        AlcoholYes.this.push(new ScreenTimeQuestions());
                    } else {
                        AlcoholYes.this.push(new HomePage());
                    }
                }
            }
        };
    }
}

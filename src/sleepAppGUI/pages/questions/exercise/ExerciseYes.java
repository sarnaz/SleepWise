package sleepAppGUI.pages.questions.exercise;

import sleepAppDatabase.Database;
import sleepAppGUI.interaction.*;
import sleepAppGUI.pages.HomePage;
import sleepAppGUI.pages.questions.ScreenTimeQuestions;
import sleepAppGUI.pages.questions.StressQuestions;
import sleepAppGUI.pages.questions.WaterQuestions;
import sleepAppProcessing.Fitness;

import java.util.Calendar;
import java.util.Date;

public class ExerciseYes extends ExerciseQuestions {

    @Override
    protected int pageNumber() {
        return 20;
    }

    @Override
    protected void setUp(Page page) {
        super.setUp(page);

        MyImage yesClicked = new MyImage(page, new int []{325, 230}, new int[] {375, 265}, "yesButton", true);
        page.pushToFront(yesClicked);
        MyText.putTextCentred(page, new int[] {400, 290}, 20, "Please enter how much you have done:");
        MyText.putTextCentred(page, new int[]{400, 320}, 20, "(to the nearest hour)");
        MyTextField exerciseHours = new MyTextField(main, page, new int[]{380, 330}, new int[]{420, 355});

        // get data from Strava
        new MyButton(page, "strava", new int[] {620, 470}, new int[]{755, 530}, "strava")
        {
            @Override
            public void isClicked() {
                // call Strava database function
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int date = calendar.get(Calendar.DAY_OF_MONTH);
                new Fitness(Database.getCurrentUserId(), date, month, year);
                Object[][] factors_chosen = Database.getFactorArray();
                if ((Boolean) factors_chosen[1][3]) {
                    ExerciseYes.this.push(new StressQuestions());
                } else if ((Boolean) factors_chosen[1][4]) {
                    ExerciseYes.this.push(new WaterQuestions());
                } else if ((Boolean) factors_chosen[1][5]) {
                    ExerciseYes.this.push(new ScreenTimeQuestions());
                } else {
                    ExerciseYes.this.push(new HomePage());
                }
            }
        };
        // next button
        new MyButton(page, "next", new int[] {360, 400}, new int[] {440, 445}, "next") {
            public void isClicked()
            {
                boolean valid = true;
                int ex = 0;
                try{
                    ex = Integer.parseInt(exerciseHours.getText());
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
                    Database.addFitnessEntry(ex, 0, date, month, year);
                    Object[][] factors_chosen = Database.getFactorArray();
                    if ((Boolean) factors_chosen[1][3]) {
                        ExerciseYes.this.push(new StressQuestions());
                    } else if ((Boolean) factors_chosen[1][4]) {
                        ExerciseYes.this.push(new WaterQuestions());
                    } else if ((Boolean) factors_chosen[1][5]) {
                        ExerciseYes.this.push(new ScreenTimeQuestions());
                    } else {
                        ExerciseYes.this.push(new HomePage());
                    }
                }
            }
        };
    }
}

package sleepAppGUI.pages;

import sleepAppDatabase.Database;
import sleepAppGUI.interaction.*;
import sleepAppGUI.interaction.graphs.MyBar;
import sleepAppGUI.pages.graphs.*;
import sleepAppGUI.visuals.ColourPalette;

import java.awt.*;
import java.util.Calendar;

public class GraphVisual extends UIViewPage {
    @Override
    protected int pageNumber() {
        return 5;
    }

    @Override
    protected void viewDidLoad() {

    }

    @Override
    protected void setUp(Page page) {
        String[] dayofweek = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};

        new MyRectangle(page, new int[] {10, 10}, new int[] {250, 235}, 20, ColourPalette.foregroundColour);
        MyImage.putImage(page, new int[] {24, 205}, 30, "waternotext");
        MyText.putText(page, new int[] {65, 230}, new int[] {200, 18}, "Water", Color.white, "Helvetica", Font.BOLD);
        new MyButton(page, "water", new Rectangle(142, 208, 110, 31), "moreinfo") {
            public void isClicked() {
                GraphVisual.this.push(new WaterGraph());
                System.out.println("water graph");
            }
        };
        MyBar water_bar = new MyBar(page, new int[] {15,20}, new int[] {255,200});
        water_bar.setGraphScale(20);
        Calendar calendar = Calendar.getInstance();
        for (int i = 4; i >= 0; i--) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int day= calendar.get(Calendar.DATE)-1;
            Object[][] data = Database.getDataForDate(year,month,day);
            if (data[1][2]!=null){
                int j = (int) data[1][2];
                double d = 1.0*j;
                water_bar.addPoint(dayofweek[7 - (day % 7)],d);
            }
            calendar.add(Calendar.DATE,-1);
        }

        new MyRectangle(page, new int[] {270, 10}, new int[] {250, 235}, 20, ColourPalette.foregroundColour);
        MyImage.putImage(page, new int[] {284, 205}, 30, "exercisenotext");
        MyText.putText(page, new int[] {322, 230}, new int[] {200, 18}, "Exercise", Color.white, "Helvetica", Font.BOLD);
        new MyButton(page, "exercise", new Rectangle(402, 208, 110, 31), "moreinfo") {
            public void isClicked()
            {
                GraphVisual.this.push(new ExerciseGraph());
                System.out.println("exercise graph");
            }
        };

        MyBar exercise_bar = new MyBar(page, new int[] {275,20}, new int[] {515,200});
        exercise_bar.setGraphScale(300);
        calendar = Calendar.getInstance();
        for (int i = 4; i >= 0; i--) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int day= calendar.get(Calendar.DATE)-1;
            Object[][] data = Database.getDataForDate(year,month,day);
            if (data[1][8]!=null){
                int j = (int) data[1][8];
                double d = 1.0*j;
                exercise_bar.addPoint(dayofweek[7 - (day % 7)],d);
            }
            calendar.add(Calendar.DATE,-1);
        }

        new MyRectangle(page, new int[] {530, 10}, new int[] {250, 235}, 20, ColourPalette.foregroundColour);
        MyImage.putImage(page, new int[] {544, 205}, 23, "screentimenotext");
        MyText.putText(page, new int[] {585, 230}, new int[] {200, 18}, "Screen", Color.white, "Helvetica", Font.BOLD);
        new MyButton(page, "screen", new Rectangle(662, 208, 110, 31), "moreinfo") {
            public void isClicked()
            {
                GraphVisual.this.push(new ScreenTimeGraph());
                System.out.println("screen graph");
            }
        };
        MyBar screen_bar = new MyBar(page, new int[] {535, 20}, new int[] {775, 200});
        screen_bar.setGraphScale(300);
        calendar = Calendar.getInstance();
        for (int i = 4; i >= 0; i--) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int day= calendar.get(Calendar.DATE)-1;
            Object[][] data = Database.getDataForDate(year,month,day);
            if (data[1][7]!=null){
                int j = (int) data[1][7];
                double d = 1.0*j;
                screen_bar.addPoint(dayofweek[7 - (day % 7)],d);
            }
            calendar.add(Calendar.DATE,-1);
        }

        new MyRectangle(page, new int[] {10, 250}, new int[] {250, 235}, 20, ColourPalette.foregroundColour);
        MyImage.putImage(page, new int[] {24, 450}, 14, "alcoholnotext");
        MyText.putText(page, new int[] {65, 472}, new int[] {200, 18}, "Alcohol", Color.white, "Helvetica", Font.BOLD);
        new MyButton(page, "alcohol", new Rectangle(142, 450, 110, 31), "moreinfo")
        {
            public void isClicked()
            {
                GraphVisual.this.push(new AlcoholGraph());
                System.out.println("alcohol graph");
            }
        };
        MyBar alcohol_bar = new MyBar(page, new int[] {15, 260}, new int[] {255, 445});
        alcohol_bar.setGraphScale(10);
        calendar = Calendar.getInstance();
        for (int i = 4; i >= 0; i--) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int day= calendar.get(Calendar.DATE)-1;
            Object[][] data = Database.getDataForDate(year,month,day);
            if (data[1][0]!=null){
                int j = (int) data[1][0];
                double d = 1.0*j;
                alcohol_bar.addPoint(dayofweek[7 - (day % 7)],d);
            }
            calendar.add(Calendar.DATE,-1);
        }

        new MyRectangle(page, new int[] {270, 250}, new int[] {250, 235}, 20, ColourPalette.foregroundColour);
        MyImage.putImage(page, new int[] {284, 445}, 30, "caffeinenotext");
        MyText.putText(page, new int[] {322, 472}, new int[] {200, 18}, "Caffeine", Color.white, "Helvetica", Font.BOLD);
        new MyButton(page, "caffeine", new Rectangle(402, 450, 110, 31), "moreinfo")
        {
            public void isClicked()
            {
                GraphVisual.this.push(new CaffeineGraph());
                System.out.println("caffeine graph");
            }
        };

        MyBar caffeine_bar = new MyBar(page, new int[] {275,260}, new int[] {515,445});
        caffeine_bar.setGraphScale(500);
        calendar = Calendar.getInstance();
        for (int i = 4; i >= 0; i--) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int day= calendar.get(Calendar.DATE)-1;
            Object[][] data = Database.getDataForDate(year,month,day);
            if (data[1][1]!=null){
                int j = (int) data[1][1];
                double d = 1.0*j;
                caffeine_bar.addPoint(dayofweek[7 - (day % 7)],d);
            }

            calendar.add(Calendar.DATE,-1);
        }


        new MyRectangle(page, new int[] {530, 250}, new int[] {250, 235}, 20, ColourPalette.foregroundColour);
        MyImage.putImage(page, new int[] {544, 450}, 30, "stressnotext");
        MyText.putText(page, new int[] {585, 472}, new int[] {200, 18}, "Stress", Color.white, "Helvetica", Font.BOLD);

        new MyButton(page, "stress", new Rectangle(662, 450, 110, 31), "moreinfo") {
            public void isClicked()
            {
                GraphVisual.this.push(new StressGraph());
                System.out.println("stress graph");
            }
        };
        MyBar stress_bar = new MyBar(page, new int[] {535,260}, new int[] {775,445});
        stress_bar.setGraphScale(500);
        calendar = Calendar.getInstance();
        for (int i = 4; i >= 0; i--) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH)+1;
            int day= calendar.get(Calendar.DATE)-1;
            Object[][] data = Database.getDataForDate(year,month,day);
            if (data[1][7]!=null){
                int j = (int) data[1][7];
                double d = 1.0*j;
                stress_bar.addPoint(dayofweek[7 - (day % 7)],d);
            }
            calendar.add(Calendar.DATE,-1);
        }

        new MyButton(page, "back", new int[] {100, 510}, new int[] {190, 540}, "back_button") {
            public void isClicked() {
                GraphVisual.this.push(new HomePage());
                System.out.println("Home Page");
            }
        };
        new MyButton(page, "suggestions", new int[] {520, 510}, new int[] {662, 540}, "settings_button") {
            public void isClicked() {
                GraphVisual.this.push(new MoreInfoPage());
            }
        };
    }
}

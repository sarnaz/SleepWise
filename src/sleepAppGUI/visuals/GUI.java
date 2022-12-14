package sleepAppGUI.visuals;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GUI
{
    private final Main main;
    private int width;
    private int height;
    //might be redundant, probably is
    private int mx = 0;
    private int my = 0;
    private JPanel canvas;


    public GUI(int wwidth, int hheight, Main mmain)
    {
        main = mmain;
        width = wwidth;
        height = hheight;
        JFrame window = new JFrame("SleepWise");

        canvas = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                if(main.getCurrentPage() != null)
                {
                    this.setBackground(main.getCurrentPage().getColour());
                    main.getCurrentPage().paintObjects(g);
                }
                else
                {
                    System.out.println("page in main is uninitialised");
                }
            }
        };
        
        canvas.addMouseMotionListener(new MouseAdapter()
		{
        	@Override
            public void mouseDragged(MouseEvent e)
            {
            	super.mouseDragged(e);
            	mx = e.getX();
                my = e.getY();
                System.out.println(mx+", "+my);
            	main.getCurrentPage().checkSliderDrag(new int[] {mx, my});
            	canvas.repaint();
            }
		});

        canvas.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mouseClicked(e);
                mx = e.getX();
                my = e.getY();
                System.out.println(mx+", "+my);
                main.getCurrentPage().checkButtons(new int[] {mx, my});
                canvas.repaint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e)
            {
            	super.mouseReleased(e);
            	mx = e.getX();
                my = e.getY();
                System.out.println(mx+", "+my);
            	main.getCurrentPage().checkSliderRelease(new int[] {mx, my});
            	canvas.repaint();
            }
        });

        window.add(canvas);
        window.setPreferredSize(new Dimension(width, height));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    public void addTextField(JTextField t) { canvas.add(t); }

    public void repaintCanvas() { canvas.repaint(); }
}

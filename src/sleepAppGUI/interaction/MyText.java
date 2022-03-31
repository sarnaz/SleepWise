package sleepAppGUI.interaction;

import java.awt.*;

public class MyText extends VObject
{
    private String text;
    private String font = "Century Gothic";
    private final Color colour;
    private int style = Font.PLAIN;

    public MyText(Page page, int[] coordinates1, int[] coordinates2, String text)
    {
        super(page, coordinates1, coordinates2, true);
        this.text = text;
        colour = Color.BLACK;
    }

    public MyText(Page page, int[] coordinates1, int[] coordinates2, String text, int[] textColour)
    {
        super(page, coordinates1, coordinates2, true);
        this.text = text;
        colour = Color.getHSBColor(textColour[0], textColour[1], textColour[2]);
    }

    public MyText(Page page, int[] coordinates1, int[] coordinates2, String text, int[] textColour, String fontName, int style)
    {
        super(page, coordinates1, coordinates2, true);
        this.text = text;
        this.font = fontName;
        this.style = style;
        colour = Color.getHSBColor(textColour[0], textColour[1], textColour[2]);
    }

    public MyText putText(Page page, int[] coordinates1, int[] size, String text, int[] textColour, String fontName, int style) {
        final int[] coordinates2 = new int[] {coordinates1[0] + size[0], coordinates1[1] + size[1]};

        return new MyText(page, coordinates1, coordinates2, text, textColour, fontName, style);
    }

    public MyText putText(Page page, int[] coordinates1, int[] size, String text) {
        return putText(page, coordinates1, size, text, new int[] {0, 0, 0}, font, style);
    }

    @Override
    public void paint(Graphics g)
    {
        g.setFont(new Font(font, style ,corner2[1] - corner1[1]));
        g.setColor(colour);
        g.drawString(text, corner1[0], corner1[1]);
    }

    public void setText(String string) { text = string; }
}

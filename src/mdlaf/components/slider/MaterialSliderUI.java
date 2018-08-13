package mdlaf.components.slider;

import java.awt.Graphics;

import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalSliderUI;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;

/**
 * 
 * @author https://github.com/vincenzopalazzo
 *
 */
public class MaterialSliderUI extends MetalSliderUI{
	
	public static ComponentUI createUI(JComponent c) {
		JSlider slider = (JSlider) c;
		//return new MaterialSliderUI(slider);
		return new MaterialSliderUI();
	}

	@Override
	public void installUI(JComponent c) {
		// TODO Auto-generated method stub
		super.installUI(c);
		JSlider slider = (JSlider) c;
		slider.setBackground(MaterialColors.WHITE);
		slider.setPaintTrack(true);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}
	
	/**
	 * original code of MetalSliderUI
	 * @return Rectangle
	 */

	private Rectangle getPaintTrackRect() {
        int trackLeft = 0, trackRight, trackTop = 0, trackBottom;
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            trackBottom = (trackRect.height - 1) - getThumbOverhang();
            trackTop = trackBottom - (getTrackWidth() - 1);
            trackRight = trackRect.width - 1;
        }
        else {
            if (this.leftToRightCache) {
                trackLeft = (trackRect.width - getThumbOverhang()) -
                                                         getTrackWidth();
                trackRight = (trackRect.width - getThumbOverhang()) - 1;
            }
            else {
                trackLeft = getThumbOverhang();
                trackRight = getThumbOverhang() + getTrackWidth() - 1;
            }
            trackBottom = trackRect.height - 1;
        }
        return new Rectangle(trackRect.x + trackLeft, trackRect.y + trackTop,
                             trackRight - trackLeft, trackBottom - trackTop);
    }
	
	/**
	 * original code of MetalSliderUI with some tricks on the colors
	 */
    public void paintTrack(Graphics g)  {
    	g.translate( trackRect.x, trackRect.y );

        int trackLeft = 0;
        int trackTop = 0;
        int trackRight;
        int trackBottom;

        // Draw the track
        if ( slider.getOrientation() == JSlider.HORIZONTAL ) {
            trackBottom = (trackRect.height - 1) - getThumbOverhang();
            trackTop = trackBottom - (getTrackWidth() - 1);
            trackRight = trackRect.width - 1;
        }
        else {
            if (this.leftToRightCache) {
                trackLeft = (trackRect.width - getThumbOverhang()) -
                                                         getTrackWidth();
                trackRight = (trackRect.width - getThumbOverhang()) - 1;
            }
            else {
                trackLeft = getThumbOverhang();
                trackRight = getThumbOverhang() + getTrackWidth() - 1;
            }
            trackBottom = trackRect.height - 1;
        }

        if ( slider.isEnabled() ) {
            g.setColor(MaterialColors.LIGHT_BLUE_400 );
            g.drawRect( trackLeft, trackTop,
                        (trackRight - trackLeft) - 1, (trackBottom - trackTop) - 1 );

            g.setColor( MaterialColors.LIGHT_BLUE_400 );
            g.drawLine( trackLeft + 1, trackBottom, trackRight, trackBottom );
            g.drawLine( trackRight, trackTop + 1, trackRight, trackBottom );

            g.setColor( MaterialColors.LIGHT_BLUE_400 );
            g.drawLine( trackLeft + 1, trackTop + 1, trackRight - 2, trackTop + 1 );
            g.drawLine( trackLeft + 1, trackTop + 1, trackLeft + 1, trackBottom - 2 );
        }
        else {
            g.setColor( MetalLookAndFeel.getControlShadow() );
            g.drawRect( trackLeft, trackTop,
                        (trackRight - trackLeft) - 1, (trackBottom - trackTop) - 1 );
        }

        // Draw the fill
        if ( filledSlider ) {
            int middleOfThumb;
            int fillTop;
            int fillLeft;
            int fillBottom;
            int fillRight;

            if ( slider.getOrientation() == JSlider.HORIZONTAL ) {
                middleOfThumb = thumbRect.x + (thumbRect.width / 2);
                middleOfThumb -= trackRect.x; // To compensate for the g.translate()
                fillTop = !slider.isEnabled() ? trackTop : trackTop + 1;
                fillBottom = !slider.isEnabled() ? trackBottom - 1 : trackBottom - 2;

                if ( !drawInverted() ) {
                    fillLeft = !slider.isEnabled() ? trackLeft : trackLeft + 1;
                    fillRight = middleOfThumb;
                }
                else {
                    fillLeft = middleOfThumb;
                    fillRight = !slider.isEnabled() ? trackRight - 1 : trackRight - 2;
                }
            }
            else {
                middleOfThumb = thumbRect.y + (thumbRect.height / 2);
                middleOfThumb -= trackRect.y; // To compensate for the g.translate()
                fillLeft = !slider.isEnabled() ? trackLeft : trackLeft + 1;
                fillRight = !slider.isEnabled() ? trackRight - 1 : trackRight - 2;

                if ( !drawInverted() ) {
                    fillTop = middleOfThumb;
                    fillBottom = !slider.isEnabled() ? trackBottom - 1 : trackBottom - 2;
                }
                else {
                    fillTop = !slider.isEnabled() ? trackTop : trackTop + 1;
                    fillBottom = middleOfThumb;
                }
            }

            if ( slider.isEnabled() ) {
                g.setColor( MaterialColors.LIGHT_BLUE_400 );
                g.drawLine( fillLeft, fillTop, fillRight, fillTop );
                g.drawLine( fillLeft, fillTop, fillLeft, fillBottom );

                g.setColor(MaterialColors.LIGHT_BLUE_400  );
                g.fillRect( fillLeft + 1, fillTop + 1,
                            fillRight - fillLeft, fillBottom - fillTop );
            }
            else {
                g.setColor( MetalLookAndFeel.getControlShadow() );
                g.fillRect(fillLeft, fillTop, fillRight - fillLeft, fillBottom - fillTop);
            }
        }

        g.translate( -trackRect.x, -trackRect.y );
    }
}

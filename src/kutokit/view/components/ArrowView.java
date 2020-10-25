package kutokit.view.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class ArrowView extends Path{
	
		int id;

	    private static final double defaultArrowHeadSize = 10.0;
	    
	    public ArrowView(double startX, double startY, double endX, double endY, double arrowHeadSize){
	        super();
	        strokeProperty().bind(fillProperty());
	        setFill(Color.BLACK);
	        
	        //Line
	        getElements().add(new MoveTo(startX, startY));
	        getElements().add(new LineTo(endX, endY));
	        
	        //ArrowHead
	        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
	        double sin = Math.sin(angle);
	        double cos = Math.cos(angle);
	        //point1
	        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
	        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
	        //point2
	        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
	        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
	        
	        getElements().add(new LineTo(x1, y1));
	        getElements().add(new LineTo(x2, y2));
	        getElements().add(new LineTo(endX, endY));
	    }
	    
	    public ArrowView(double startX, double startY, double endX, double endY, int id){
	        this(startX, startY, endX, endY, defaultArrowHeadSize);
	        this.id=id;
	    }
	    
	    public int getID() {
	    	return id;
	    }
}

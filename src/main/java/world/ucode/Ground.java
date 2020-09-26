package world.ucode;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Ground extends ObjectGame {
    static double YOfLastGround;
    public double speed = 6;

    Ground(double x, double y, double width, double height, Image image) {
        this.height = height;
        this.width = width;
        this.image = image;
        this.y = y;

        if (this.YOfLastGround <= x) {
            this.YOfLastGround = x;
        }

        canvas = new Canvas(this.width, this.height);
        canvas.setTranslateX(this.YOfLastGround);
        canvas.setTranslateY(400);
        draw();

        this.x = this.YOfLastGround;
        this.YOfLastGround += width;
    }

    @Override
    public void updateObject() {
        if (this.x < -(this.width)) {
            this.x = YOfLastGround;
            YOfLastGround += this.width;
        }
        if (YOfLastGround == this.x + this.width) {
            YOfLastGround -= speed;
        }
        this.x -= speed;
        canvas.setTranslateX(this.x);
    }

    @Override
    public void Restart() {

    }
}
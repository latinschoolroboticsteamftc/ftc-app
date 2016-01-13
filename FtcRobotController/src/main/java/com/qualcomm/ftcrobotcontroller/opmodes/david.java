package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class david extends OpMode
{
    //Edit these to change moter power. ================================================================================================
    double mainPower = 1;               //
    double driveTrainPower = 1;         //
    double armPower = .5;                //
    //Edit these to change moter power. ================================================================================================

    DcMotor frontr, frontl, backr, backl, height, string, boxa, boxt;
    Servo boxr, boxl, arm;

    @Override
    public void init() {
        //The sides of the box
        boxr = hardwareMap.servo.get("boxr");
        boxl = hardwareMap.servo.get("boxl");
        //The final beam on the arm (only for pulluping)?
        arm = hardwareMap.servo.get("arm");

        //1st degree
        height = hardwareMap.dcMotor.get("height");
        //Reel
        string = hardwareMap.dcMotor.get("string");
        //The angle of the box (3rd degree)
        boxa = hardwareMap.dcMotor.get("boxa");
        //The tilt of the box (2nd degree)1
        boxt = hardwareMap.dcMotor.get("boxt");

        //Drive train (self explanatory)
        frontr = hardwareMap.dcMotor.get("frontr");
        frontl = hardwareMap.dcMotor.get("frontl");
        backr = hardwareMap.dcMotor.get("backr");
        backl = hardwareMap.dcMotor.get("backl");
        //Configure drive train
        backl.setDirection(DcMotor.Direction.REVERSE);
        frontl.setDirection(DcMotor.Direction.REVERSE);
        frontr.setDirection(DcMotor.Direction.FORWARD);
        backr.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {
        double power = .5;

        telemetry.addData("", backr.getCurrentPosition());

        if(gamepad1.back)
        {
            boxa.setTargetPosition(0);
        }

        if(gamepad1.a)
            power = 1;


        //Movement
        gamepad1.setJoystickDeadzone(0);
        frontl.setPower(mainPower * driveTrainPower * power * (gamepad1.left_stick_y + gamepad1.left_stick_x));
        backl.setPower(mainPower * driveTrainPower * power *(gamepad1.left_stick_y+gamepad1.left_stick_x));

        frontr.setPower(mainPower * driveTrainPower * power *(gamepad1.left_stick_y-gamepad1.left_stick_x));
        backr.setPower(mainPower * driveTrainPower * power *(gamepad1.left_stick_y-gamepad1.left_stick_x));

        //STRING
        string.setPower((gamepad1.left_bumper?1:0)-(gamepad1.right_bumper?1:0));
        if(gamepad1.left_bumper)
        {
            string.setPower(mainPower);
        }
        else if(gamepad1.right_bumper)
        {
            string.setPower(-mainPower);
        }
        else
        {
            string.setPower(0.0);
        }

        //HEIGHT
        float height_power = 0.7f;

        height.setPower(0);
        if(gamepad1.dpad_down)
            height.setPower(mainPower*armPower*height_power);
        if(gamepad1.dpad_up)
            height.setPower(-mainPower*armPower*height_power);

        //BOXA THE PITCH OF THE BOX
        float pitchSpeed = 0.3f;
        boxa.setPower(0.0);
        if(gamepad1.dpad_left)
            boxa.setPower(mainPower*armPower*pitchSpeed);
        if(gamepad1.dpad_right)
            boxa.setPower(-mainPower*armPower*pitchSpeed);

        //BOXTilt

        //TO reverse switch negatives or the left and right triggers.
        float tilt_power = 0.15f;


        boxt.setPower(tilt_power*(gamepad1.left_trigger-gamepad1.right_trigger));


        //ARM
        if(gamepad1.a)
        {
            arm.setPosition(1.0);
        }
        else
        {
            arm.setPosition(0.0);
        }


        //SERVO
        if(gamepad1.start) {
            boxr.setPosition(0.0);
            boxl.setPosition(1.0);
        }
        else
        {
            boxr.setPosition(1.0);
            boxl.setPosition(0.0);
        }
    }
}
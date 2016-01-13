package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class Simple_Dpad extends OpMode {

    DcMotor frontr;
    DcMotor frontl;
    DcMotor backr;
    DcMotor backl;
    DcMotor height;
    DcMotor string;
    DcMotor boxa;
    DcMotor boxt;
    Servo boxr;
    Servo boxl;
    Servo arm;
    double mainPower = 1;
    double driveTrainPower = 1;
    double armPower = .5;
    /*TODO 2
    * Maybe create a function that implements all of the simple if else logic. For example, just input the two different
    * types of buttons on teh controller and input the two values it is set to, else will be automatic. Actually nevermind setposition vs setpower to complicated to be worthwhile.
    *
    *
    *
    * */

    //Check ports.

    //impliment smooth for box tilt

    double armposition;
    boolean armdelta;
    double armspeed;

    @Override
    public void init() {
        frontr = hardwareMap.dcMotor.get("frontr");
        frontl = hardwareMap.dcMotor.get("frontl");
        backr = hardwareMap.dcMotor.get("backr");
        backl = hardwareMap.dcMotor.get("backl");
        height = hardwareMap.dcMotor.get("height");
        string = hardwareMap.dcMotor.get("string");
        boxa = hardwareMap.dcMotor.get("boxa");
        boxt = hardwareMap.dcMotor.get("boxt");
        backl.setDirection(DcMotor.Direction.FORWARD);
        frontl.setDirection(DcMotor.Direction.FORWARD);
        frontr.setDirection(DcMotor.Direction.REVERSE);
        backr.setDirection(DcMotor.Direction.REVERSE);
        height.setDirection(DcMotor.Direction.REVERSE);
        armposition = 0;
        armspeed = 0.1;
        armdelta = true;

        //SERVOS
        boxr = hardwareMap.servo.get("boxr");
        boxl = hardwareMap.servo.get("boxl");
        arm = hardwareMap.servo.get("arm");

    }



    @Override
    public void loop() {

        boolean up = gamepad1.dpad_up;
        boolean down = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_right;
        boolean right = gamepad1.dpad_left;
        double power;

        telemetry.addData("", backr.getCurrentPosition());


        //Victory Dance

//        if(gamepad1.right_bumper)
//        {
//            frontl.setDirection(DcMotor.Direction.FORWARD);
//            frontr.setDirection(DcMotor.Direction.REVERSE);
//        }

        if(gamepad1.back)
        {
            boxa.setTargetPosition(0);
        }


        //Reduce front power
        if(gamepad1.a)
        {
            power = 1.0;
        }
        else
        {
            power = 0.5;
        }


        if(up)
        {
            frontr.setPower(power);
            frontl.setPower(power);
            backr.setPower(power);
            backl.setPower(power);
        }

        else if(down)
        {
            frontr.setPower(-power);
            frontl.setPower(-power);
            backr.setPower(-power);
            backl.setPower(-power);
        }

        else if(left)
        {
            frontr.setPower(-power);
            frontl.setPower(power);
            backr.setPower(-power);
            backl.setPower(power);
        }

        else if(right)
        {

            frontr.setPower(power);
            frontl.setPower(-power);
            backr.setPower(power);
            backl.setPower(-power);
        }

        else {
            frontr.setPower(0.0);
            frontl.setPower(0.0);
            backl.setPower(0.0);
            backr.setPower(0.0);
        }

        gamepad1.setJoystickDeadzone(0);
        frontl.setPower(mainPower * driveTrainPower * power * (gamepad1.left_stick_y + gamepad1.left_stick_x));
        backl.setPower(mainPower * driveTrainPower * power *(gamepad1.left_stick_y+gamepad1.left_stick_x));

        frontr.setPower(mainPower * driveTrainPower * power *(gamepad1.left_stick_y-gamepad1.left_stick_x));
        backr.setPower(mainPower * driveTrainPower * power *(gamepad1.left_stick_y-gamepad1.left_stick_x));
        /**
         * GAMEPAD 2:
         *
         * String = left and right bumpers.
         * roll of box = triggers
         * Hook = a
         * height = DPAD up/down
         * pitch of box = DPAD left/right
         * balls out = START
         *
         * ONLY DPAD DRIVE ON GAMEPAD 1.
         *
         * A = MORE POWER.
         * **/

        //Brainstorm for limiting the tilt of dc motors.


        //Slow down power on teh tilting.
        //Lock arm.




        //STRING
        if(gamepad1.left_bumper)
        {
            string.setPower(0.8);
        }
        else if(gamepad1.right_bumper)
        {
            string.setPower(-0.8);
        }
        else
        {
            string.setPower(0.0);
        }

        //HEIGHT

        float height_power = 0.8f;


        if(gamepad2.dpad_down)
        {
            height.setPower(0.8);
        }
        else if(gamepad2.dpad_up)
        {
            height.setPower(-height_power);
        }
        else if (gamepad1.x)
        {
            height.setPower(1);
        }

//BOXA THE PITCH OF THE BOX
        float pitchSpeed = 0.30f;
        if(gamepad2.b)
        {
            boxa.setPower(pitchSpeed);
        }
        else if(gamepad2.y)
        {
            boxa.setPower(-pitchSpeed);
        }
        else
        {
            boxa.setPower(0.0);
        }

        //BOXT

        //TO reverse switch negatives or the left and right triggers.
        float tilt_power = 0.2f;


        if(gamepad2.left_trigger > 0) {
            boxt.setPower(tilt_power*gamepad2.left_trigger);
        }
        else if(gamepad2.right_trigger > 0) {
            boxt.setPower(-tilt_power*gamepad2.right_trigger);
        }
        else
        {
            boxt.setPower(0.0);
        }

        //ARM
        if(gamepad2.a)
        {
            arm.setPosition(0.0);
        }
        else
        {
            arm.setPosition(1.0);
        }


        //SERVO
        if(gamepad2.start) {
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
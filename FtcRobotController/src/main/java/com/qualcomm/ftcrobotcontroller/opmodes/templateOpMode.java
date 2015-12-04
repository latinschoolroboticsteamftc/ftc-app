package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class templateOpMode extends LinearOpMode {

    DcMotor frontr;//front right motor
    DcMotor frontl;//front left motor
    DcMotor backr;// back right motor
    DcMotor backl;// back left motor
    DcMotor height;//Wtf????
    DcMotor string;//Wtf????
    DcMotor boxa;//Wtf????
    DcMotor boxt;//Wtf????
    Servo boxr;//Wtf????
    Servo boxl;//Wtf????
    Servo arm;//Wtf????
    double armposition;
    boolean armdelta;
    double armspeed;
    Encoder frontre;
    Encoder frontle;
    Encoder backre;
    Encoder backle;



    /*TODO
    * Maybe create a function that implements all of the simple if else logic. For example, just input the two different
    * types of buttons on teh controller and input the two values it is set to, else will be automatic. Actually nevermind setposition vs setpower to complicated to be worthwhile.
    *
    *
    *
    * */


    // Encoder class for rotation data.

    public class Encoder {
        public int CurrentPositionModifier = 0;
        public int OldPosition = 0;

        protected DcMotor Motor;

        public Encoder(DcMotor motor) {
            this.Motor = motor;
        }

        public DcMotor getMotor() {
            return this.Motor;
        }

        public void setCurrentPosition(int position) {
            this.CurrentPositionModifier = position;
            this.OldPosition = this.Motor.getCurrentPosition();
        }

        public int getCurrentPosition() {
            return (this.Motor.getCurrentPosition() - this.OldPosition) + this.CurrentPositionModifier;
        }

        public void setTargetPosition(int target) {
            this.Motor.setTargetPosition((this.OldPosition + target) - this.CurrentPositionModifier);
        }

        public int getTargetPosition() {
            return (this.Motor.getTargetPosition() - this.OldPosition) + this.CurrentPositionModifier;
        }
    }


    //Check ports.

    //impliment smooth for box tilt
    public void runOpMode() {
        frontr = hardwareMap.dcMotor.get("frontr");
        frontl = hardwareMap.dcMotor.get("frontl");
        backr = hardwareMap.dcMotor.get("backr");
        backl = hardwareMap.dcMotor.get("backl");
        height = hardwareMap.dcMotor.get("height");
        string = hardwareMap.dcMotor.get("string");
        boxa = hardwareMap.dcMotor.get("boxa");
        boxt = hardwareMap.dcMotor.get("boxt");
        backl.setDirection(DcMotor.Direction.REVERSE);
        frontl.setDirection(DcMotor.Direction.REVERSE);
        frontr.setDirection(DcMotor.Direction.FORWARD);
        backr.setDirection(DcMotor.Direction.FORWARD);
        height.setDirection(DcMotor.Direction.REVERSE);
        armposition = 0;
        armspeed = 0.1;
        armdelta = true;
        //SERVOS
        boxr = hardwareMap.servo.get("boxr");
        boxl = hardwareMap.servo.get("boxl");
        arm = hardwareMap.servo.get("arm");
        // No idea what this is
        telemetry.addData("frontr", frontr.getCurrentPosition());
        telemetry.addData("frontl", frontl.getCurrentPosition());
        telemetry.addData("backr", backr.getCurrentPosition());
        telemetry.addData("backl", backl.getCurrentPosition());
        telemetry.addData("height", height.getCurrentPosition());
        telemetry.addData("string", string.getCurrentPosition());
        telemetry.addData("boxa", boxa.getCurrentPosition());
        telemetry.addData("boxt", boxt.getCurrentPosition());
        //setting motors in order to enable to detect the orientation
        frontr.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        frontl.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        backr.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        backl.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        height.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        string.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        boxa.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        boxt.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        // intialising encoder class with the DCmotor in order to get the  data
        frontre = new Encoder (frontr);
        frontle = new Encoder (frontl);
        backre = new Encoder (backr);
        backle = new Encoder (backl);

        frontre.setCurrentPosition(10);
        frontle.setCurrentPosition(10);
        backre.setCurrentPosition(10);
        backle.setCurrentPosition(180);
        frontr.setPower(1);
        frontl.setPower(1);
        backr.setPower(1);
        backl.setPower(1);
        frontre.setTargetPosition(100);
        frontle.setTargetPosition(100);
        backre.setTargetPosition(100);
        backle.setTargetPosition(100);

    }


}
//USEFUL STUFF

//        DcMotor motorRight;
//        DcMotor motorLeft;
//        motorRight = hardwareMap.dcMotor.get("motor_2");
//        motorLeft.setDirection(DcMotor.Direction.REVERSE);
//        motor_Front_Left.setPower(1.0);

//        float throttle = -gamepad1.left_stick_y;
//        float direction = gamepad1.left_stick_x;
//        float right = throttle - direction;
//        gamepad1.a
//telemetry.addData("Text", "*** Robot Data***");

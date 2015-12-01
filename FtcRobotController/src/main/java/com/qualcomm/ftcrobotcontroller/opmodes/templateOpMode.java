package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
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

    /*TODO
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

        armposition = 0;
        armspeed = 0.1;
        armdelta = true;

        //SERVOS
        boxr = hardwareMap.servo.get("boxr");
        boxl = hardwareMap.servo.get("boxl");
        arm = hardwareMap.servo.get("arm");

        frontr.setPower(0.3);
        frontl.setPower(0.3);
        backr.setPower(0.3);
        backl.setPower(0.3);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("I was interrupted!");
            e.printStackTrace();
        }
        frontr.setPower(0);
        frontl.setPower(0);
        backr.setPower(0);
        backl.setPower(0);
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

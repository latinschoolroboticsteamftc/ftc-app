package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class forwardBlocksame extends LinearOpMode{

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
        frontr.setPower(0.5);
        frontl.setPower(0.5);
        backr.setPower(0.5);
        backl.setPower(0.5);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Something has gone horribly wrong ");
        }
        frontr.setPower(0);
        frontl.setPower(0);
        backr.setPower(0);
        backl.setPower(0);
    }


}

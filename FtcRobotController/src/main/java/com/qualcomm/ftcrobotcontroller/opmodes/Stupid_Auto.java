package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

public class Stupid_Auto extends LinearOpMode{

    DcMotor frontr;
    DcMotor frontl;
    DcMotor backr;
    DcMotor backl;
    DcMotor height;
    DcMotor boxa;

    //slep function
    public void slep(double a){
        int t;
        t = (int) Math.floor(1000 * a);
        try
        {
            sleep(t); // 1 second
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        // Detecting and setting orientation of motors

        frontr = hardwareMap.dcMotor.get("frontr");
        frontl = hardwareMap.dcMotor.get("frontl");
        backr = hardwareMap.dcMotor.get("backr");
        backl = hardwareMap.dcMotor.get("backl");
        height = hardwareMap.dcMotor.get("height");
        boxa = hardwareMap.dcMotor.get("boxa");
        backl.setDirection(DcMotor.Direction.FORWARD);
        frontl.setDirection(DcMotor.Direction.FORWARD);
        frontr.setDirection(DcMotor.Direction.REVERSE);
        backr.setDirection(DcMotor.Direction.REVERSE);
        height.setDirection(DcMotor.Direction.REVERSE);
        // Declaring Variables double idle;
        double idle;
        double drive;
        double shoulder;
        double arm;
        double e;

        // Configuring Timing
        idle = 7;
        drive = 5;
        shoulder = 4;
        arm = 3;

        //Power Levels and Drive Control

        // Idle 1
        frontl.setPower(-0.0);
        frontr.setPower(-0.0);
        backl.setPower(-0.0);
        backr.setPower(-0.0);
        waitOneFullHardwareCycle();
        slep(idle);
        // Drive 1
        frontl.setPower(-0.5);
        frontr.setPower(-0.5);
        backl.setPower(-0.5);
        backr.setPower(-0.5);
        waitOneFullHardwareCycle();
        slep(drive);
        // Shoulder Height
        frontl.setPower(0.0);
        frontr.setPower(0.0);
        backl.setPower(0.0);
        backr.setPower(0.0);
        height.setPower(-0.15);
        waitOneFullHardwareCycle();
        slep(shoulder);
        // Arm Height
        frontl.setPower(0.0);
        frontr.setPower(0.0);
        backl.setPower(0.0);
        backr.setPower(0.0);
        height.setPower(0.0);
        boxa.setPower(0.3);
        waitOneFullHardwareCycle();
        slep(arm);
        // Stop Code
        frontl.setPower(0.0);
        frontr.setPower(0.0);
        backl.setPower(0.0);
        backr.setPower(0.0);
        height.setPower(0.0);
        boxa.setPower(-0.0);
        waitOneFullHardwareCycle();

        }
    }
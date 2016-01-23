package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

import android.media.MediaPlayer;
import android.util.Log;

import com.qualcomm.ftcrobotcontroller.FtcRobotControllerActivity;
import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.LightSensor;
//import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.robocol.Telemetry;

public class templateOpMode extends LinearOpMode implements driveBase{

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
         private static final String LOG_TAG = templateOpMode.class.getSimpleName();
            //    ColorSensor color;
            //  OpticalDistanceSensor distance
            ElapsedTime elapsedTime;
            public void startMotors(double power1, double power2, double power3, double power4) {
                backr.setPower(power1);
                backl.setPower(power2);
                frontl.setPower(power3);
                frontr.setPower(power4);
            }
            public void first() {
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

            }
            public int getEncoderAvg() {
                return (Math.abs(backl.getCurrentPosition()) + Math.abs(backr.getCurrentPosition()) + Math.abs(frontl.getCurrentPosition()) + Math.abs(frontr.getCurrentPosition())) / 4;
            }
            public void stopMotors() {
                backr.setPower(0);
                backl.setPower(0);
                frontl.setPower(0);
                frontr.setPower(0);
            }
            public void resetEncoders() {
                backl.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                backr.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                frontr.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                frontl.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            }
            public void getEncoderValues() {
                telemetry.addData("backl", backl.getCurrentPosition());

                telemetry.addData("frontr", frontr.getCurrentPosition());

                telemetry.addData("backr", backr.getCurrentPosition());

                telemetry.addData("frontl", frontl.getCurrentPosition());
            }
            public void getTime() {
                telemetry.addData("time", elapsedTime.time());
            }
            @Override
            public void runOpMode() {
                first();
                try {
                    waitOneFullHardwareCycle();
                } catch (InterruptedException e) {
                    Log.i(LOG_TAG, e.toString());
                }
                try {
                    waitForStart();
                } catch (InterruptedException e) {
                    Log.i(LOG_TAG, e.toString());
                }
                int distance1 = 5000; // TODO: 11/19/2015 CORRECT VALUES
                int distance2 = 7075; // TODO: 11/19/2015 CORRECT VALUES
                int distance3 = 12750; // TODO: 11/19/2015 CORRECT VALUES
                int currentEncoder = 0;
                int nullEncoder = 0;
                while (currentEncoder < distance1) {
                    startMotors(-1, 1, 1, -1);
                }

                stopMotors();
                resetEncoders();
                nullEncoder = 0;
                elapsedTime.reset();
                stopMotors();
                backl.close();
                frontl.close();
                backr.close();
                frontr.close();
            }
        }
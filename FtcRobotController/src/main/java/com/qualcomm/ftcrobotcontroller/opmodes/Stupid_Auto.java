package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

public class Stupid_Auto extends LinearOpMode{
    DcMotor frontr;//front right motor
    DcMotor frontl;//front left motor
    DcMotor backr;// back right motor
    DcMotor backl;// back left motor

    private void sleep(int seconds)
    {
        try
        {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    ElapsedTime bob = new ElapsedTime();

    @Override
    public void runOpMode() {


        frontr = hardwareMap.dcMotor.get("frontr");
        frontl = hardwareMap.dcMotor.get("frontl");
        backr = hardwareMap.dcMotor.get("backr");
        backl = hardwareMap.dcMotor.get("backl");

        backl.setDirection(DcMotor.Direction.REVERSE);
        frontl.setDirection(DcMotor.Direction.REVERSE);
        frontr.setDirection(DcMotor.Direction.FORWARD);
        backr.setDirection(DcMotor.Direction.FORWARD);

        sleep(15);

        double power = 1.0;
        while(bob.time()>15 && bob.time()<25)
        {
            frontr.setPower(power);
            frontl.setPower(power);
            backr.setPower(power);
            backl.setPower(power);
        }

        power = 0.0;

        frontr.setPower(power);
        frontl.setPower(power);
        backr.setPower(power);
        backl.setPower(power);

        backl.close();
        frontl.close();
        backr.close();
        frontr.close();


    }
}

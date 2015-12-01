package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class templateOpMode extends OpMode {


    @Override
    public void init() {

    }

    @Override
    public void loop() {

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

package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class Motor_Encoder_Test extends OpMode {
    DcMotor motor_one;

    @Override
    public void init() {
        motor_one = hardwareMap.dcMotor.get("motor_one");
    }

    @Override
    public void loop() {
        telemetry.addData("MotorEncoder", motor_one.getCurrentPosition());
    }
}

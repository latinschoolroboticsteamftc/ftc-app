package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class joysticks extends OpMode {

    DcMotor motor_front_right;
    DcMotor motor_front_left;
    DcMotor motor_back_right;
    DcMotor motor_back_left;

    @Override
    public void init() {
        motor_front_right = hardwareMap.dcMotor.get("motor_front_right");
        motor_front_left = hardwareMap.dcMotor.get("motor_front_left");
        motor_back_right = hardwareMap.dcMotor.get("motor_back_right");
        motor_back_left = hardwareMap.dcMotor.get("motor_back_left");
        telemetry.addData("", "***Everything Loaded OK***");
    }

    @Override
    public void loop() {
        float y = gamepad1.left_stick_y;
        float x = gamepad1.left_stick_x;

        if(x>0)
        {
            //Turning right
            motor_front_right.setPower((1.0 - x)*y);
            motor_front_left.setPower(1.0*y);
            motor_back_right.setPower((1.0 - x)*y);
            motor_back_left.setPower(1.0*y);
        }
        else if(x<0)
        {
            //Turning right
            motor_front_left.setPower((-1.0 - x)*y);
            motor_front_right.setPower(1.0*y);
            motor_back_left.setPower((-1.0 - x)*y);
            motor_back_right.setPower(1.0*y);
        }
        else if(y == 0) {
            //All the way right and all the way left.
            if(x>0)
            {
                motor_front_right.setPower(0.0);
                motor_front_left.setPower(x);
                motor_back_right.setPower(0.0);
                motor_back_left.setPower(x);
            }
            else if (x<0)
            {
                motor_front_right.setPower(x);
                motor_front_left.setPower(0.0);
                motor_back_right.setPower(x);
                motor_back_left.setPower(0.0);
            }
        }
        else
        {
            //Straight, as powerful as forward.
            motor_front_left.setPower(y);
            motor_front_right.setPower(y);
            motor_back_left.setPower(y);
            motor_back_right.setPower(y);
        }
    }
}


//top-left -
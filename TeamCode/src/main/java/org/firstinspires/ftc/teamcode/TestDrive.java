package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TestDrive")
public class TestDrive extends OpMode {

    final static double MOTOR_POWER = 0.15;


    DcMotor motorLeft;
    DcMotor motorRight;
    //Servo arm;


    public TestDrive(){

    }

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get("rightMotor");
        motorLeft = hardwareMap.dcMotor.get("leftMotor");
        //arm = hardwareMap.servo.get("centerArm");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {

        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float leftX = gamepad1.left_stick_x;



        motorLeft.setPower(leftY);
        motorRight.setPower(leftY);
        //motorRight.setPower(rightY);
        //arm.setPosition(rightY);

    }
}
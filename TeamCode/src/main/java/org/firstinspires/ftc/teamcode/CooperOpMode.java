package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Raja on 11/6/2017.
 */
@TeleOp(name = "CooperOpmode")
public class CooperOpMode extends OpMode{

    final static double MOTOR_POWER=0.15 ;

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorJack;

    public CooperOpMode(){}

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get("rightMotor");
        motorLeft = hardwareMap.dcMotor.get("leftMotor");
        motorJack = hardwareMap.dcMotor.get("jackMotor");
        //arm = hardwareMap.servo.get("centerArm");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.FORWARD);
        motorJack.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float leftX = gamepad1.left_stick_x;
        float lefty = gamepad2.left_stick_y;



        motorLeft.setPower(leftY);
        motorRight.setPower(leftY);
        motorJack.setPower(lefty);
        //motorRight.setPower(rightY);
        //arm.setPosition(rightY);

    }


}


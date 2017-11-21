package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class DeviceUtils {

    public static void goForward(DcMotor motorLeft, DcMotor motorRight, float power) {
        //power = checkMaxSpeed(power);

        motorLeft.setDirection(DcMotor.Direction.FORWARD);
        motorRight.setDirection(DcMotor.Direction.FORWARD);

        motorLeft.setPower(power);
        motorRight.setPower(power);
    }

    public static void goBackward(DcMotor motorLeft, DcMotor motorRight, float power) {
        //power = checkMaxSpeed(power);

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        motorLeft.setPower(-power);
        motorRight.setPower(-power);
    }

    public static void turnLeft(DcMotor motorLeft, DcMotor motorRight, float power) {
        //power = checkMaxSpeed(power);

        motorLeft.setDirection(DcMotor.Direction.FORWARD);

        motorRight.setDirection(DcMotor.Direction.REVERSE);

        motorLeft.setPower(power);
        motorRight.setPower(power);
    }

    public static void turnRight(DcMotor motorLeft, DcMotor motorRight, float power) {
        //power = checkMaxSpeed(power);

        motorLeft.setDirection(DcMotor.Direction.FORWARD);
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        motorLeft.setPower(power);
        motorRight.setPower(power);
    }

    public static void startDriving(DcMotor motorLeft, DcMotor motorRight, Gamepad gamepad1) {
        double throttle = gamepad1.left_stick_y;

        motorLeft.setPower(gamepad1.left_stick_y);
        motorRight.setPower(gamepad1.right_stick_x);
    }

    public static void startArmMotor(DcMotor armMotor, Gamepad gamepad1) {
        if (gamepad1.y) {
            armMotor.setPower(0.1);
        } else {
            armMotor.setPower(0);
        }
    }
}
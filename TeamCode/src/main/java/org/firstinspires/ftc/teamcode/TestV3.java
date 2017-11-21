package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TESTv.3")
public class TestV3 extends OpMode {

    final static double MOTOR_POWER = 0.15;

    DcMotor motorRight;
    DcMotor motorLeft;
    DcMotor motorJack;

    DcMotor motorArm;

    public TestV3(){

    }

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get("rightMotor");
        motorLeft = hardwareMap.dcMotor.get("leftMotor");
        motorJack = hardwareMap.dcMotor.get("jackMotor");
        motorArm = hardwareMap.dcMotor.get("armMotor");


        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.FORWARD);
        //motorJack.setDirection(DcMotor.Direction.REVERSE);

        motorJack.setPower(-1);
    }

    @Override
    public void loop() {
        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float DPUP = gamepad1.dpad_up  ? 1.0f : 0.0f;
        float DPWN = gamepad1.dpad_down  ? 1.0f : 0.0f;
        float UY = gamepad2.y ? 1.0f : 0.0f;
        float DA = gamepad2.a ? -1.0f : 0.0f;

        motorJack.setPower(gamepad2.right_stick_x);

        motorLeft.setPower(leftY);
        motorRight.setPower(rightY);

        if (gamepad1.dpad_up) {
            motorJack.setPower(DPUP);
        }
        else if (gamepad1.dpad_down) {
            motorJack.setPower(DPWN);
        }
        else {
            motorJack.setPower(0.0);
        }

        if (gamepad2.y) {
            motorArm.setPower(UY);
        }
        else if (gamepad2.a) {
            motorArm.setPower(DA);
        }
        else {
            motorArm.setPower(0.0);
        }


    }
}

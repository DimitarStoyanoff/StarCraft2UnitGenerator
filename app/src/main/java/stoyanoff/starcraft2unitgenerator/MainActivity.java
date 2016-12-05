package stoyanoff.starcraft2unitgenerator;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Switch hypeSwitch;
    private TextView protossUnitText;
    private TextView terranUnitText;
    private TextView zergUnitText;
    private TextView captionText;
    private String[] protossUnits;
    private String[] terranUnits;
    private String[] zergUnits;
    private String[] captions;
    private String captionNormal;
    private Resources res;
    private int random;
    private boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        protossUnitText = (TextView) findViewById(R.id.protossUnitText);
        terranUnitText =(TextView) findViewById(R.id.terranUnitText);
        zergUnitText = (TextView) findViewById(R.id.zergUnitText);
        captionText = (TextView) findViewById(R.id.captionText);
        hypeSwitch = (Switch) findViewById(R.id.hype_switch);

        res = getResources();
        protossUnits = res.getStringArray(R.array.protoss_units);
        terranUnits = res.getStringArray(R.array.terran_units);
        zergUnits = res.getStringArray(R.array.zerg_units);
        captionNormal = res.getString(R.string.caption_normal);

        random = new Random().nextInt(protossUnits.length);
        protossUnitText.setText(protossUnits[random]);
        random = new Random().nextInt(terranUnits.length);
        terranUnitText.setText(terranUnits[random]);
        random = new Random().nextInt(zergUnits.length);
        zergUnitText.setText(zergUnits[random]);

        hypeSwitch.setChecked(false);
        hypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                checked = isChecked;
            if(isChecked){
                hypeSwitch.setText("TOO MUCH FUCKING HYPE");
                protossUnits = res.getStringArray(R.array.protoss_cool_units);
                terranUnits = res.getStringArray(R.array.terran_cool_units);
                zergUnits = res.getStringArray(R.array.zerg_cool_units);
                captions = res.getStringArray(R.array.cool_captions);
            }else{
                hypeSwitch.setText("Not enough swears?");
                protossUnits = res.getStringArray(R.array.protoss_units);
                terranUnits = res.getStringArray(R.array.terran_units);
                zergUnits = res.getStringArray(R.array.zerg_units);
                captionText.setText(captionNormal);
            }
            }
        });
    }


    public void repickButtonClick(View view) {

        if(checked) {
            random = new Random().nextInt(captions.length);
            captionText.setText(captions[random]);

        }
        random = new Random().nextInt(protossUnits.length);
        protossUnitText.setText(protossUnits[random]);
        random = new Random().nextInt(terranUnits.length);
        terranUnitText.setText(terranUnits[random]);
        random = new Random().nextInt(zergUnits.length);
        zergUnitText.setText(zergUnits[random]);


    }
}

/*
 * Copyright (C) 2011-2012 Dominik Schürmann <dominik@dominikschuermann.de>
 *
 * This file is part of AdAway.
 *
 * AdAway is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AdAway is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AdAway.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.adaway.ui.tcpdump;

import org.adaway.R;
import org.adaway.helper.ThemeHelper;
import org.adaway.ui.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class TcpdumpLogActivity extends AppCompatActivity {
    private ActionBar mActionBar;
    private TcpdumpLogFragment mLogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeHelper.applyTheme(this);

        this.setContentView(R.layout.tcpdump_log_activity);
        this.mLogFragment = (TcpdumpLogFragment) this.getSupportFragmentManager().findFragmentById(R.id.tcpdump_log_fragment);

        this.mActionBar = getSupportActionBar();
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayShowTitleEnabled(true);
            this.mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.tcpdump_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in Action Bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case R.id.refresh:
                this.mLogFragment.refreshLog();
                return true;
            case R.id.clear:
                this.mLogFragment.clearLog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

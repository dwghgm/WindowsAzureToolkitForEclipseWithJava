/**
* Copyright 2014 Microsoft Open Technologies, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*	 http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/

package com.microsoftopentechnologies.wacommon.commoncontrols;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.microsoftopentechnologies.wacommon.utils.PreferenceSetUtil;
import com.microsoftopentechnologies.wacommon.utils.WACommonException;
/**
 * Class configure publish settings download dialog.
 * Opens browser to download publish settings file.
 */
public class PublishSettingsDialog extends Dialog {
	
	/**
	 * Constructor.
	 * @param parentShell
	 */
	protected PublishSettingsDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.mgmtPortalShell);
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		return null;
	}

	@Override
	protected Button createButton(Composite parent,
			int id, String label,
			boolean defaultButton) {
		return null;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Browser browser = new Browser(parent, SWT.BORDER | SWT.FILL);
		FillLayout layout = new FillLayout();
		browser.setLayout(layout);
		browser.setSize(900, 600);
		try {
			browser.setUrl(PreferenceSetUtil.
					getSelectedPublishSettingsURL(
							PreferenceSetUtil.
							getSelectedPreferenceSetName()));
		} catch (WACommonException e) {
			e.printStackTrace();
		}
		return parent;
	}
}

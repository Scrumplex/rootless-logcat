/*
 * Copyright 2016 Anton Tananaev (anton.tananaev@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tananaev.logcat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line {

    private static Pattern linePattern = Pattern.compile("\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d\\.\\d\\d\\d (\\w)/.*");

    private char level = 'D';
    private String content;

    public Line(String content) {
        this.content = content;
        Matcher matcher = linePattern.matcher(content);
        if (matcher.matches()) {
            level = matcher.group(1).charAt(0);
        }
    }

    public char getLevel() {
        return level;
    }

    public String getContent() {
        return content;
    }

}
